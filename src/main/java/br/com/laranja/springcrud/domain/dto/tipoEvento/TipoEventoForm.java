package br.com.laranja.springcrud.domain.dto.tipoEvento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
public class TipoEventoForm {

    private Long idTipoEvento;

    @NotNull
    private String nome;

    @NotNull
    private boolean situacao;
}
