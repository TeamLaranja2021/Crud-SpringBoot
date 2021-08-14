package br.com.laranja.springcrud.domain.dto.usuario;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UsuarioRequest {
    private Long idUsuario;
    private String nome;
    private String email;
    private String senha;
}
