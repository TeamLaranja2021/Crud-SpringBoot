package br.com.laranja.springcrud.domain.dto.versao;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class VersaoForm {

    private Long idversao;

    @NotNull @NotEmpty
    private String gmud;
    @NotNull @NotEmpty
    private String descricao;
    @NotNull
    private LocalDate dataLancamento;
    @NotNull
    private Boolean situacao;
    @NotNull
    private Integer ordem;
    @NotNull @NotEmpty
    private String numeroVersao;
    @NotNull
    private Long idProjeto;

}
