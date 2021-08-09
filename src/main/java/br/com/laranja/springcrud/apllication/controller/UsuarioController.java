package br.com.laranja.springcrud.apllication.controller;

import java.util.List;

import br.com.laranja.springcrud.infrastructure.exception.UsuarioNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.laranja.springcrud.domain.model.Usuario;
import br.com.laranja.springcrud.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    // pega todos os usuarios
    @GetMapping("/usuario")
    public ResponseEntity<List<Usuario>> getAllUser(){
        return  ResponseEntity.ok(usuarioService.getAllUsers());
    }

    // pega 1 usuario com o errorHandler
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long idUsuario){
        return  ResponseEntity.ok(usuarioService.getUserById(idUsuario));
    }

    // deletar usaurio do sistema pelo  login
   @DeleteMapping("/usuario/{idUsuario}")
    public  ResponseEntity deleteUserById(@PathVariable Long idUsuario) throws UsuarioNotFoundException {
        usuarioService.deleteUserById(idUsuario);
        return  ResponseEntity.ok().build();
    }

    @PostMapping("/usuario")
    public  ResponseEntity<Usuario> saveUser(@RequestBody Usuario usuario){
        return  ResponseEntity.ok(usuarioService.saveUser(usuario));

    }

    //Update do Usuario
//    @PutMapping("/usuario/{idUsuario}")
    public  ResponseEntity<Usuario> updateUserById(@PathVariable Long idUsuario, @RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.updateUserById(idUsuario, usuario));
    }
}
