package br.com.laranja.springcrud.domain.service;

import br.com.laranja.springcrud.domain.dto.RequisicaoRequest;
import br.com.laranja.springcrud.domain.model.Requisicao;


import java.util.List;


public interface RequisicaoService {
    List<Requisicao> getAllRequisicao();

   Requisicao getRequisicaoById(Long idRequisicao);

    Requisicao createRequiscao(RequisicaoRequest requisicaoRequest);

    Requisicao updateRequisicaoId(Long idRequisicao ,RequisicaoRequest requisicaoRequest);

    void deleteRequisicaoById(Long idRequisicao);


}
