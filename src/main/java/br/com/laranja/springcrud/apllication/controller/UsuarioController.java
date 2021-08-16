package br.com.laranja.springcrud.apllication.controller;

import java.util.List;

import br.com.laranja.springcrud.domain.dto.usuario.UsuarioForm;
import br.com.laranja.springcrud.domain.dto.usuario.UsuarioRequest;
import br.com.laranja.springcrud.domain.dto.usuario.UsuarioResponse;
import br.com.laranja.springcrud.domain.dto.versao.VersaoResponse;
import br.com.laranja.springcrud.infrastructure.exception.UsuarioNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.laranja.springcrud.domain.model.Usuario;
import br.com.laranja.springcrud.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    // pega todos os usuarios
    @GetMapping("/usuario")
    public ResponseEntity<List<UsuarioResponse>> getAllUser(){
        return  ResponseEntity.ok(UsuarioResponse.convertList(usuarioService.getAllUsers()));
    }

    // pega 1 usuario com o errorHandler
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<UsuarioResponse> getUserById(@PathVariable Long id){
        return  ResponseEntity.ok(new UsuarioResponse(usuarioService.getUserById(id)));
    }

    // deletar usaurio do sistema pelo  login
   @DeleteMapping("/usuario/{idUsuario}")
    public  ResponseEntity deleteUserById(@PathVariable Long id) throws UsuarioNotFoundException {
        usuarioService.deleteUserById(id);
        return  ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public void getTokin(@RequestBody UsuarioRequest usuarioRequest){
        usuarioService.getToken(usuarioRequest);
    }

    @PostMapping("/usuario")
    public  ResponseEntity<Usuario> saveUser(@Valid @RequestBody Usuario usuario){
        return  ResponseEntity.ok(usuarioService.saveUser(usuario));

    }

    //Update do Usuario
//    @PutMapping("/usuario/{idUsuario}")
   /* public  ResponseEntity<Usuario> updateUserById(@PathVariable Long idUsuario, @RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.updateUserById(idUsuario, usuario));
    }*/
}
