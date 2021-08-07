package br.com.laranja.springcrud.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;



@Data
@AllArgsConstructor
@Builder
public class RequisicaoRequest {
    private Long idRequisicao;
    private String urlhomolog;
    private String uriprod;
    private String descricao;
    private Integer requisicaoPai;
    private String camada;
    private boolean situacao;
    private Long idEvento;
}
