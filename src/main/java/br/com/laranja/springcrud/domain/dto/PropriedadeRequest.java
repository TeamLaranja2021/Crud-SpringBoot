package br.com.laranja.springcrud.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PropriedadeRequest {
    private Long idPropriedade;
    private String chave;
    private String valor;
    private Integer  ordem;
    private Long idRequisicao;
}
