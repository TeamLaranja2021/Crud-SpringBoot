package br.com.laranja.springcrud.domain.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@Builder
public class UsuarioForm {
    private Long idUsuario;

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String senha;
}
