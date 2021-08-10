package br.com.laranja.springcrud.domain.dto.usuario;

import br.com.laranja.springcrud.domain.dto.versao.VersaoResponse;
import br.com.laranja.springcrud.domain.model.Usuario;
import br.com.laranja.springcrud.domain.model.Versao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
public class UsuarioResponse {
    private Long idUsuario;
    private String nome;
    private String email;


    public UsuarioResponse(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    public static List<UsuarioResponse> convertList(List<Usuario> Ususario) {
        return Ususario.stream().map(UsuarioResponse::new).collect(Collectors.toList());
    }
}
