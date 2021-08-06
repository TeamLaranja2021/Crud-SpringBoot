package br.com.laranja.springcrud.domain.service.impl;


import br.com.laranja.springcrud.domain.dto.VersaoRequest;
import br.com.laranja.springcrud.domain.model.Versao;
import br.com.laranja.springcrud.domain.service.VersaoService;
import br.com.laranja.springcrud.infrastructure.exception.UsuarioNotFoundException;
import br.com.laranja.springcrud.infrastructure.exception.VersaoNotFoundException;
import br.com.laranja.springcrud.infrastructure.repository.VersaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@RequiredArgsConstructor
@Service
public class VersaoServiceImpl implements VersaoService {
    private  final VersaoRepository versaoRepository;

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
        Versao versao = Versao.builder()
                .tela(versaoRequest.getTela())
                .projeto(versaoRequest.getProjeto())
                .gmud(versaoRequest.getGmud())
                .descricao(versaoRequest.getDescricao())
                .dataLancamento(versaoRequest.getDataLancamento())
                .situacao(versaoRequest.getSituacao())
                .ordem(versaoRequest.getOrdem())
                .numeroVersao(versaoRequest.getNumeroVersao())
                .build();
        return versaoRepository.save(versao);
    }

    @Override
    public Versao updateVersaoById(Long idVersao, VersaoRequest versaoRequest) {
        return null;
    }

    @Override
    @Transient
    public void deleteByIdVersao(Long idVersao) {
        versaoRepository.deleteByIdVersao(idVersao);
    }
}
