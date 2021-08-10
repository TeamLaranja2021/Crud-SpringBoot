package br.com.laranja.springcrud.domain.dto.propriedade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
public class PropriedadeForm {
    private Long idPropriedade;

    @NotNull
    private String chave;

    @NotNull
    private Integer valor;

    @NotNull
    private Integer  ordem;

    @NotNull
    private Long idRequisicao;
}
