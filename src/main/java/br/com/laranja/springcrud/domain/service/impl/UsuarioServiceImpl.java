package br.com.laranja.springcrud.domain.service.impl;

import br.com.laranja.springcrud.domain.dto.usuario.UsuarioForm;
import br.com.laranja.springcrud.domain.dto.usuario.UsuarioRequest;
import br.com.laranja.springcrud.domain.external.client.JwtClient;
import br.com.laranja.springcrud.domain.model.Usuario;
import br.com.laranja.springcrud.domain.service.UsuarioService;
import br.com.laranja.springcrud.infrastructure.exception.UsuarioNotFoundException;
import br.com.laranja.springcrud.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private  final UsuarioRepository usuarioRepository;

    @Autowired
    private JwtClient jwtClient;

    // pega todos os usuarios do sistema
    @Override
    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUserById(Long id) {
        return usuarioRepository.findById(id).orElseThrow( () -> new UsuarioNotFoundException(id));
    }

    //Ciar Usaurio e como regra de negocio que nao pode ter 1 usuario com o mesmo login
    @Override
    public Usuario saveUser(Usuario usuario) {
            usuario.setCreatedDate(LocalDateTime.now());
            usuario.setUpdatedDate(LocalDateTime.now());

        return  usuarioRepository.save(usuario);
    }


    //AtuAlizar Usuario
 /*   @Override
    public Usuario updateUserById(Long idUsuario, UsuarioRequest usuarioRequest) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);

        //verifica se tem o id no banco
        if(!usuarioOptional.isPresent()){
            throw  new UsuarioNotFoundException(idUsuario);
        }

        Usuario usuarioExistent = usuarioOptional.get();
        return  usuarioRepository.save(usuarioRequest.builder()
                .idUsuario(usuarioExistent.getIdUsuario()) // vai verificar se o id ja existe
                .nome(usuarioRequest.getNome())
                .email(usuarioRequest.getEmail())
                .createdDate(usuarioExistent.getCreatedDate())
                .updatedDate(LocalDateTime.now())
                .build());

    }*/

    @Transactional
    @Override
    public void deleteUserById(Long id) throws UsuarioNotFoundException{
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        //verifica se tem o id no banco
        if(!usuarioOptional.isPresent()){
            throw  new UsuarioNotFoundException(id);
        }

        usuarioRepository.deleteById(id);
    }
    @Override
    public void getToken(UsuarioRequest usuarioRequest){
        jwtClient.token(usuarioRequest);
    }

}
