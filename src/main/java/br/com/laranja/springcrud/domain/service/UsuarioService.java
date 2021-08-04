package br.com.laranja.springcrud.domain.service;

import br.com.laranja.springcrud.domain.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> getAllUsers(); // todos os usuarios

    Usuario getUserById(Long idUsuario); // pega 1 usuario pelo id

    void deleteUserByName(String nome); // deletar usuario pelo id

    Usuario saveUser(Usuario usuario); // Criar Usaurio
}
