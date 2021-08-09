package br.com.laranja.springcrud.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EventoRequest{
    private Long idEvento;
    private boolean situacao;
    private Integer ordem;
    private String parametros;
    private Long tipoEvento;
    private Long tela;
    private Long requisicao;

}
