package br.com.laranja.springcrud.domain.service.impl;

import br.com.laranja.springcrud.domain.dto.RequisicaoRequest;
import br.com.laranja.springcrud.domain.model.Evento;
import br.com.laranja.springcrud.domain.model.Requisicao;
import br.com.laranja.springcrud.domain.service.RequisicaoService;
import br.com.laranja.springcrud.infrastructure.exception.EventoNotFoundException;
import br.com.laranja.springcrud.infrastructure.exception.RequisicaoNotFoundException;
import br.com.laranja.springcrud.infrastructure.repository.EventoRepository;
import br.com.laranja.springcrud.infrastructure.repository.RequisicaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequisicaoServiceImpl implements RequisicaoService {
    private  final RequisicaoRepository requisicaoRepository;
    private  final EventoRepository eventoRepository;

    @Override
    public List<Requisicao> getAllRequisicao() {
        return requisicaoRepository.findAll();
    }

    @Override
    public Requisicao getRequisicaoById(Long idRequisicao) {
        return requisicaoRepository.findById(idRequisicao).orElseThrow(() -> new RequisicaoNotFoundException(idRequisicao));
    }

    @Override
    public Requisicao createRequiscao(RequisicaoRequest requisicaoRequest) {
       Optional<Evento> Optionalevento = eventoRepository.findById(requisicaoRequest.getIdEvento());

        if (Optionalevento.isEmpty() ){
            throw  new EventoNotFoundException(requisicaoRequest.getIdEvento());
        }

        Requisicao requisicao = Requisicao.builder()
                .urlhomolog(requisicaoRequest.getUrlhomolog())
                .uriprod(requisicaoRequest.getUriprod())
                .descricao(requisicaoRequest.getDescricao())
                .requisicaoPai(requisicaoRequest.getRequisicaoPai())
                .camada(requisicaoRequest.getCamada())
                .situacao(requisicaoRequest.isSituacao())
                .evento(Optionalevento.get())
                .build();
        return requisicaoRepository.save(requisicao);
    }

    @Override
    public Requisicao updateRequisicaoId(Long idRequisicao, RequisicaoRequest requisicaoRequest) {
        Optional<Requisicao> requisicaoOptional = requisicaoRepository.findById(idRequisicao);

        if (requisicaoOptional.isEmpty()){
            throw  new RequisicaoNotFoundException(idRequisicao);
        }

        Optional<Evento> Optionalevento = eventoRepository.findById(requisicaoRequest.getIdEvento());
        if (Optionalevento.isEmpty()){
            throw  new EventoNotFoundException(requisicaoRequest.getIdEvento());
        }

        Evento EventoExistent  = Optionalevento.get();

        return  requisicaoRepository.save(Requisicao.builder()
                .urlhomolog(requisicaoRequest.getUrlhomolog())
                .idRequisicao(requisicaoOptional.get().getIdRequisicao())
                .uriprod(requisicaoRequest.getUriprod())
                .descricao(requisicaoRequest.getDescricao())
                .requisicaoPai(requisicaoRequest.getRequisicaoPai())
                .camada(requisicaoRequest.getCamada())
                .situacao(requisicaoRequest.isSituacao())
                 .evento(EventoExistent)
                .build());
    }


    @Transactional
    @Override
    public void deleteRequisicaoById(Long idRequisicao) {
        requisicaoRepository.deleteByIdRequisicao(idRequisicao);
    }



}
