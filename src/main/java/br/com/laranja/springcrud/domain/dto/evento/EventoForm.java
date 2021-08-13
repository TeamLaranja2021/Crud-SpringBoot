package br.com.laranja.springcrud.domain.dto.evento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
public class EventoForm {
    private Long idEvento;

    @NotNull
    private boolean situacao;
    @NotNull
    private Integer ordem;
    @NotNull
    private String parametros;
    @NotNull
    private Long tipoEvento;
    @NotNull
    private Long tela;
    @NotNull
    private Long requisicao;
}
