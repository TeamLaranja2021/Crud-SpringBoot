package br.com.laranja.springcrud.domain.dto.tela;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class TelaForm {
    private Long idtela;

    @NotNull
    private LocalDate dataCadastro;

    @NotNull
    private String nomeTela;

    @NotNull
    private String imagem;

    @NotNull
    private boolean situacao;

    @NotNull
    private Integer telaPai;

    @NotNull
    private Integer ordem;

    @NotNull
    private String urlLog;

    @NotNull
    private Integer versaoOrigem;

    @NotNull
    private Long idVersao;
}
