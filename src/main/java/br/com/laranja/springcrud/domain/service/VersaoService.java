package br.com.laranja.springcrud.domain.service;

import br.com.laranja.springcrud.domain.dto.versao.VersaoRequest;
import br.com.laranja.springcrud.domain.model.Versao;

import java.util.List;

public interface VersaoService {

    List<Versao> getAllVersao();

    Versao getVersaoById(Long idVersao); // listagem de um projetos pelo id

    Versao createVersao(VersaoRequest versaoRequest); // criação dos projetos

    Versao updateVersaoById(Long idVersao, VersaoRequest versaoRequest); // atualização dos projetos pelo id

    void deleteByIdVersao(Long idVersao); // exclusão dos projetos  pelo id
}
