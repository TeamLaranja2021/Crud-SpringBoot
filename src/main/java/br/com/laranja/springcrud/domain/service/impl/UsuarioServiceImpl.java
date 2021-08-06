package br.com.laranja.springcrud.domain.service.impl;

import br.com.laranja.springcrud.domain.dto.UsuarioRequest;
import br.com.laranja.springcrud.domain.model.Usuario;
import br.com.laranja.springcrud.domain.service.UsuarioService;
import br.com.laranja.springcrud.infrastructure.exception.UsuarioNotFoundException;
import br.com.laranja.springcrud.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


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


    //AtuAlizar Usuario
    @Override
    public Usuario updateUserById(Long idUsuario, Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);

        //verifica se tem o id no banco
        if(!usuarioOptional.isPresent()){
            throw  new UsuarioNotFoundException(idUsuario);
        }

        Usuario usuarioExistent = usuarioOptional.get();
        return  usuarioRepository.save(usuario.builder()
                .idUsuario(usuarioExistent.getIdUsuario()) // vai verificar se o id ja existe
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .createdDate(usuarioExistent.getCreatedDate())
                .updatedDate(LocalDateTime.now())
                .build());

    }


}
