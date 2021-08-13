package br.com.laranja.springcrud.domain.dto.requiscao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
public class RequisicaoForm {
    private Long idRequisicao;

    @NotNull
    private String urlhomolog;

    @NotNull
    private String uriprod;

    @NotNull
    private String descricao;

    @NotNull
    private Integer requisicaoPai;

    @NotNull
    private String camada;

    @NotNull
    private boolean situacao;

    @NotNull
    private Long idEvento;
}
