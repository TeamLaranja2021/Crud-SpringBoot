package br.com.laranja.springcrud.apllication.controller;

import br.com.laranja.springcrud.infrastructure.exception.ProjetoNotFoundException;
import br.com.laranja.springcrud.infrastructure.exception.TelaNotFoundException;
import br.com.laranja.springcrud.infrastructure.exception.UsuarioNotFoundException;
import br.com.laranja.springcrud.infrastructure.exception.VersaoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<String> usuarioNotFound(UsuarioNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(ProjetoNotFoundException.class)
    public ResponseEntity<String> projetoNotFound(ProjetoNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }


    @ExceptionHandler(VersaoNotFoundException.class)
    public ResponseEntity<String> versaoNotFound(VersaoNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(TelaNotFoundException.class)
    public ResponseEntity<String> TelaNotFound(TelaNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }


}

