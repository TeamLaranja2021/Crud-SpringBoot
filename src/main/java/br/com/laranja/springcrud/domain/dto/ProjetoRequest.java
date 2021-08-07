package br.com.laranja.springcrud.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class ProjetoRequest {
    private Long idProjeto;
    private String nome;
    private boolean situacao;

}
