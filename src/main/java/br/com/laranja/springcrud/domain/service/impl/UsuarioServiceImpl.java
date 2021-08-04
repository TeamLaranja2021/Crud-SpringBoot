package br.com.laranja.springcrud.domain.service.impl;

import br.com.laranja.springcrud.domain.model.Usuario;
import br.com.laranja.springcrud.domain.service.UsuarioService;
import br.com.laranja.springcrud.infrastructure.exception.UsuarioNotFoundException;
import br.com.laranja.springcrud.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private  final UsuarioRepository usuarioRepository;

    // pega todos os usuarios do sistema
    @Override
    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUserById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).orElseThrow( () -> new UsuarioNotFoundException(idUsuario));
    }

    @Transactional
    @Override
    public void deleteUserByName(String nome) {
         usuarioRepository.deleteByNome(nome);
    }


    //Ciar Usaurio e como regra de negocio que nao pode ter 1 usuario com o mesmo login
    @Override
    public Usuario saveUser(Usuario usuario) {
            usuario.setCreatedDate(LocalDateTime.now());
            usuario.setUpdatedDate(LocalDateTime.now());

        return  usuarioRepository.save(usuario);
    }


}
