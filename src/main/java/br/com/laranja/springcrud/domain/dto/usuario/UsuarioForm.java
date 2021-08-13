package br.com.laranja.springcrud.domain.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@Builder
public class UsuarioForm {
    private Long idUsuario;

    @NotNull
    private String nome;

    @NotNull
    private String email;
}
