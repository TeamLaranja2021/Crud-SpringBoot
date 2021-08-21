package br.com.laranja.springcrud.domain.service.impl;


import br.com.laranja.springcrud.domain.dto.TelaRequest;
import br.com.laranja.springcrud.domain.dto.VersaoRequest;
import br.com.laranja.springcrud.domain.model.*;
import br.com.laranja.springcrud.domain.service.VersaoService;
import br.com.laranja.springcrud.infrastructure.exception.EntityWithDependentsException;
import br.com.laranja.springcrud.infrastructure.exception.ProjetoNotFoundException;
import br.com.laranja.springcrud.infrastructure.exception.TelaNotFoundException;
import br.com.laranja.springcrud.infrastructure.exception.VersaoNotFoundException;
import br.com.laranja.springcrud.infrastructure.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VersaoServiceImpl implements VersaoService {
    private  final VersaoRepository versaoRepository;
    private  final ProjetoRepository projetoRepository;
    private final TelaRepository telaRepository;
    private final EventoRepository eventoRepository;
    private final TipoEventoRepository tipoEventoRepository;
    private final RequisicaoRepository requisicaoRepository;
    private final PropriedadeRepository propriedadeRepository;

    @Override
    public List<Versao> getAllVersao() {
        return versaoRepository.findAll();
    }

    @Override
    public Versao getVersaoById(Long idVersao) {
        return versaoRepository.findById(idVersao).orElseThrow( () -> new VersaoNotFoundException(idVersao));
    }

    @Override
    public Versao createVersao(VersaoRequest versaoRequest) {
        Optional<Projeto> OptionalProjeto = projetoRepository.findById(versaoRequest.getIdProjeto());

        if (OptionalProjeto.isEmpty() ){
            throw  new ProjetoNotFoundException(versaoRequest.getIdProjeto());
        }

        Versao versao1 = Versao.builder()
                .gmud(versaoRequest.getGmud())
                .descricao(versaoRequest.getDescricao())
                .dataLancamento(versaoRequest.getDataLancamento())
                .situacao(versaoRequest.getSituacao())
                .ordem(versaoRequest.getOrdem())
                .numeroVersao(versaoRequest.getNumeroVersao())
                .projeto(OptionalProjeto.get())
                .build();
        return versaoRepository.save(versao1);
    }

    @Override
    public Versao updateVersaoById(Long idVersao, VersaoRequest versaoRequest) {
      Optional<Versao> VersaoOptional = versaoRepository.findById(idVersao);

        if (!VersaoOptional.isPresent()) {
            throw new VersaoNotFoundException(idVersao);
        }
        Optional<Projeto> OptionalProjeto = projetoRepository.findById(versaoRequest.getIdProjeto());

        if (!OptionalProjeto.isPresent()) {
            throw new ProjetoNotFoundException(versaoRequest.getIdProjeto());
        }
        Projeto projetoExistent = OptionalProjeto.get();

      return versaoRepository.save( Versao.builder()
                .gmud(versaoRequest.getGmud())
                .descricao(versaoRequest.getDescricao())
                .dataLancamento(versaoRequest.getDataLancamento())
                .situacao(versaoRequest.getSituacao())
                .ordem(versaoRequest.getOrdem())
                .numeroVersao(versaoRequest.getNumeroVersao())
                .projeto(projetoExistent)
                .build());
    }

    @Override
    @Transactional
    public void deleteByIdVersao(Long idVersao) {
        versaoRepository.deleteByIdVersao(idVersao);
    }

    public void clonarTelas(Versao versaoCriada, Long idVersao) {
        Optional<Versao> versaoClone = versaoRepository.findById(idVersao);

        if (versaoClone.isEmpty()) {
            throw new VersaoNotFoundException(idVersao);
        }

        List<Tela> telas = telaRepository.findByVersao_Id(idVersao);
        List<Tela> novasTelas = new ArrayList<>();

        for(Tela tela : telas) {
            Tela telaClone = Tela.builder()
                    .versao(versaoCriada)
                    .nomeTela(tela.getNomeTela())
                    .imagem(tela.getImagem())
                    .situacao(tela.isSituacao())
                    .ordem(tela.getOrdem())
                    .urlLog(tela.getUrlLog())
                    .dataCadastro(tela.getDataCadastro())
                    .telaPai(tela.getTelaPai())
                    .build();

            Tela novaTela = telaRepository.save(telaClone);

            novasTelas.add(novaTela);

            clonarEventos(novaTela, tela.getIdTela());
        }

        int i = 0;
        for (Tela tela: telas) {
            if (!Objects.isNull(tela.getTelaPai())) {
                int telaPaiIndex = telas.indexOf(tela.getTelaPai());

                Tela telaAtualizada = novasTelas.get(i);

                telaAtualizada.setTelaPai(novasTelas.get(telaPaiIndex));

                telaRepository.save(telaAtualizada);
            }
            i++;
        }
    }

    public void clonarEventos(Tela telaCriada, Long idTela) {
        List<Evento> eventos = eventoRepository.findAllByScreenId(idTela);

        for (Evento evento : eventos) {
            Evento eventoCriado = Evento.builder()
                    .tela(telaCriada)
                    .tipoEvento(evento.getTipoEvento())
                    .situacao(evento.getTela().isSituacao())
                    .ordem(evento.getOrdem())
                    .parametros(evento.getParametros())
                    .build();

            Evento novoEvento = eventoRepository.save(eventoCriado);

            clonarRequisicao(novoEvento, evento.getIdEvento());
        }
    }

    public void clonarRequisicao(Evento eventoCriado, Long idEvento) {
        List<Requisicao> requisicoes = requisicaoRepository.getAllByEvent_Id(idEvento);

        List<Requisicao> novasRequisicoes = new ArrayList<>();

        for (Requisicao requisicao : requisicoes) {
            Requisicao requisicaoCriada = Requisicao.builder()
                    .urlhomolog(requisicao.getUrlhomolog())
                    .evento(eventoCriado)
                    .uriprod(requisicao.getUriprod())
                    .descricao(requisicao.getDescricao())
                    .camada(requisicao.getCamada())
                    .situacao(requisicao.isSituacao())
                    .build();

            Requisicao novaRequisicao = requisicaoRepository.save(requisicaoCriada);

            novasRequisicoes.add(novaRequisicao);

            clonarPropriedade(novaRequisicao, requisicao.getIdRequisicao());
        }

        int i = 0;
        for (Requisicao requisicao: requisicoes) {
            if (!Objects.isNull(requisicao.getRequisicaoPai())) {
                int requisicaoPaiIndex = requisicoes.indexOf(requisicao.getRequisicaoPai());

                Requisicao requisicaoAtualizada = novasRequisicoes.get(i);

                requisicaoAtualizada.setRequisicaoPai(novasRequisicoes.get(requisicaoPaiIndex));

                requisicaoRepository.save(requisicaoAtualizada);
            }
            i++;
        }


    }

    public void clonarPropriedade(Requisicao requisicaoCriada, Long idRequisicao) {
        List<Propriedade> propriedades = propriedadeRepository.findAllByRequest_Id(idRequisicao);

        for (Propriedade propriedade : propriedades) {
            Propriedade propriedadeCriada = Propriedade.builder()
                    .requisicao(requisicaoCriada)
                    .chave(propriedade.getChave())
                    .valor(propriedade.getValor())
                    .ordem(propriedade.getOrdem())
                    .build();

            propriedadeRepository.save(propriedadeCriada);
        }
    }
}
