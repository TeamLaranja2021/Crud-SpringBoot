package br.com.laranja.springcrud.domain.service;

import br.com.laranja.springcrud.domain.dto.usuario.UsuarioForm;
import br.com.laranja.springcrud.domain.dto.usuario.UsuarioRequest;
import br.com.laranja.springcrud.domain.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> getAllUsers(); // todos os usuarios

    Usuario getUserById(Long idUsuario); // pega 1 usuario pelo id

    void deleteUserById(Long idUsuario); // deletar usuario pelo id

    Usuario saveUser(Usuario usuario); // Criar Usaurio

    void getToken(UsuarioRequest usuarioRequest);

  //  Usuario updateUserById(Long idUsuario , UsuarioRequest usuarioRequest); // atualizar os dados dos usuario
}
