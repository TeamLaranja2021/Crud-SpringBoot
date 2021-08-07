package br.com.laranja.springcrud.domain.service.impl;


import br.com.laranja.springcrud.domain.dto.TelaRequest;
import br.com.laranja.springcrud.domain.model.Projeto;
import br.com.laranja.springcrud.domain.model.Tela;
import br.com.laranja.springcrud.domain.model.Versao;
import br.com.laranja.springcrud.domain.service.TelaService;
import br.com.laranja.springcrud.infrastructure.exception.ProjetoNotFoundException;
import br.com.laranja.springcrud.infrastructure.exception.TelaNotFoundException;
import br.com.laranja.springcrud.infrastructure.exception.VersaoNotFoundException;
import br.com.laranja.springcrud.infrastructure.repository.TelaRepository;
import br.com.laranja.springcrud.infrastructure.repository.VersaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TelaServiceImpl implements TelaService {
    private final TelaRepository telaRepository;
    private  final VersaoRepository versaoRepository;

    @Override
    public List<Tela> getAllTelas() {
        return telaRepository.findAll();
    }

    @Override
    public Tela getTelaById(Long idTela) {
        return telaRepository.findById(idTela).orElseThrow( () -> new TelaNotFoundException(idTela));
    }

    @Override
    public Tela createTela(TelaRequest telaRequest) {
        Optional<Versao> Optionalversao = versaoRepository.findById(telaRequest.getIdVersao());

        if (Optionalversao.isEmpty() ){
            throw  new VersaoNotFoundException(telaRequest.getIdVersao());
        }

        Tela tela = Tela.builder()
                .dataCadastro(telaRequest.getDataCadastro())
                .nomeTela(telaRequest.getNomeTela())
                .imagem(telaRequest.getImagem())
                .situacao(telaRequest.isSituacao())
                .telaPai(telaRequest.getTelaPai())
                .ordem(telaRequest.getOrdem())
                .urlLog(telaRequest.getUrlLog())
                .versaoOrigem(telaRequest.getVersaoOrigem())
                .versao(Optionalversao.get())
                .build();
        return telaRepository.save(tela);
    }

    @Override
    public Tela updateTelaId(Long idTela, TelaRequest telaRequest) {
        Optional<Tela> TelaOptional = telaRepository.findById(idTela);

        if (!TelaOptional.isPresent()) {
            throw new VersaoNotFoundException(idTela);
        }

        Optional<Versao> Optionalversao = versaoRepository.findById(telaRequest.getIdVersao());

        Versao versaoExistent = Optionalversao.get();

       return telaRepository.save(Tela.builder()
                .dataCadastro(telaRequest.getDataCadastro())
                .nomeTela(telaRequest.getNomeTela())
                .imagem(telaRequest.getImagem())
                .situacao(telaRequest.isSituacao())
                .telaPai(telaRequest.getTelaPai())
                .ordem(telaRequest.getOrdem())
                .urlLog(telaRequest.getUrlLog())
                .versaoOrigem(telaRequest.getVersaoOrigem())
                .versao(versaoExistent)
                .build());

    }

    @Transactional
    @Override
    public void deleteTelaById(Long idTela) {
       telaRepository.deleteByIdTela(idTela);
    }
}
