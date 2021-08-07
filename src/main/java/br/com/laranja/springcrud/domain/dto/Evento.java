package br.com.laranja.springcrud.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class Evento {
    private Long idEvento;
    private Long tipoEvento;
    private Long tela;
    private boolean situacao;
    private Integer ordem;
    private String parametros;
}
