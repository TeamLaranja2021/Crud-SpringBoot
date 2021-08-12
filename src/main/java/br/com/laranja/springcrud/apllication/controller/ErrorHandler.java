package br.com.laranja.springcrud.apllication.controller;


import br.com.laranja.springcrud.domain.service.LogService;
import br.com.laranja.springcrud.infrastructure.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
public class ErrorHandler {
    private final LogService loger;

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<String> usuarioNotFound(UsuarioNotFoundException e){
        loger.log(e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(ProjetoNotFoundException.class)
    public ResponseEntity<String> projetoNotFound(ProjetoNotFoundException e){
        loger.log(e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }


    @ExceptionHandler(VersaoNotFoundException.class)
    public ResponseEntity<String> versaoNotFound(VersaoNotFoundException e){
        loger.log(e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(TelaNotFoundException.class)
    public ResponseEntity<String> TelaNotFound(TelaNotFoundException e){
        loger.log(e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(EventoNotFoundException.class)
    public ResponseEntity<String> EventoNotFound(EventoNotFoundException e){
        loger.log(e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(TipoEventoNotFoundException.class)
    public ResponseEntity<String> TipoEventoNotFound(TipoEventoNotFoundException e){
        loger.log(e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(EntityWithDependentsException.class)
    public ResponseEntity<String> EntityWithDependentsException(EntityWithDependentsException e){
        loger.log(e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(RequisicaoNotFoundException.class)
    public ResponseEntity<String> RequisicaoNotFound(RequisicaoNotFoundException e){
        loger.log(e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(PropriedadeNotFoundException.class)
    public ResponseEntity<String> PropriedadeNotFound(PropriedadeNotFoundException e){
        loger.log(e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<FieldError>> FieldNotFound(MethodArgumentNotValidException e){
        loger.log(e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getFieldErrors());
    }
}

