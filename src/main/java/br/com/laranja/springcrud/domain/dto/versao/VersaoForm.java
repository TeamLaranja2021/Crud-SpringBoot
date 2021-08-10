package br.com.laranja.springcrud.domain.dto.versao;


import br.com.laranja.springcrud.domain.model.Projeto;
import br.com.laranja.springcrud.domain.model.Tela;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class VersaoForm {

    private Long idversao;

    @NotNull
    private String gmud;
    @NotNull
    private String descricao;
    @NotNull
    private LocalDate dataLancamento;
    @NotNull
    private Boolean situacao;
    @NotNull
    private Integer ordem;
    @NotNull
    private String numeroVersao;
    @NotNull
    private Long idProjeto;
    @NotNull
    private Long idTela;

}
