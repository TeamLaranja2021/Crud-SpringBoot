package br.com.laranja.springcrud.domain.dto.projeto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
public class ProjetoForm {
    private Long idProjeto;

    @NotNull
    private String nome;
    @NotNull
    private boolean situacao;
}
