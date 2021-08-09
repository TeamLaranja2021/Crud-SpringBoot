package br.com.laranja.springcrud.domain.service.impl;


import br.com.laranja.springcrud.domain.dto.VersaoRequest;
import br.com.laranja.springcrud.domain.model.Projeto;
import br.com.laranja.springcrud.domain.model.Tela;
import br.com.laranja.springcrud.domain.model.Versao;
import br.com.laranja.springcrud.domain.service.VersaoService;
import br.com.laranja.springcrud.infrastructure.exception.EntityWithDependentsException;
import br.com.laranja.springcrud.infrastructure.exception.ProjetoNotFoundException;
import br.com.laranja.springcrud.infrastructure.exception.TelaNotFoundException;
import br.com.laranja.springcrud.infrastructure.exception.VersaoNotFoundException;
import br.com.laranja.springcrud.infrastructure.repository.ProjetoRepository;
import br.com.laranja.springcrud.infrastructure.repository.TelaRepository;
import br.com.laranja.springcrud.infrastructure.repository.VersaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VersaoServiceImpl implements VersaoService {
    private  final VersaoRepository versaoRepository;
    private  final ProjetoRepository projetoRepository;

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
}
