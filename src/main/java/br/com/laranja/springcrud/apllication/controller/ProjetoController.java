package br.com.laranja.springcrud.apllication.controller;

import br.com.laranja.springcrud.domain.dto.ProjetoRequest;
import br.com.laranja.springcrud.domain.model.Projeto;
import br.com.laranja.springcrud.domain.service.ProjetoService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjetoController {
    private final ProjetoService projetoService;



    @GetMapping("/projeto")
    public ResponseEntity<List<Projeto>> getAllCollaborator() {
        return ResponseEntity.ok(projetoService.getAllProjetos());
    }


    @GetMapping("/projeto/{idProjeto}")
    public ResponseEntity<Projeto> getProjetoById(@PathVariable Long idProjeto) {
        return ResponseEntity.ok(projetoService.getProjetoById(idProjeto));
    }


    @PostMapping("/projeto")
    public ResponseEntity<Projeto> createProjeto(@RequestBody ProjetoRequest projetoRequest) {
        return ResponseEntity.ok(projetoService.createProjeto(projetoRequest));
    }


    @PutMapping("/projeto/{idProjeto}")
    public ResponseEntity<Projeto> updateProjetoById(@PathVariable Long idProjeto, @RequestBody ProjetoRequest projetoRequest) {
        return ResponseEntity.ok(projetoService.updateProjetoById(idProjeto,projetoRequest));
    }


    @DeleteMapping("/projeto/{idProjeto}")
    public ResponseEntity deleteProjeotById(@PathVariable Long idProjeto) {
        projetoService.deleteProjetoById(idProjeto);
        return ResponseEntity.ok().build();
    }

}

