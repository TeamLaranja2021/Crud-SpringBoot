package br.com.laranja.springcrud.apllication.controller;


import br.com.laranja.springcrud.domain.dto.ProjetoRequest;
import br.com.laranja.springcrud.domain.dto.VersaoRequest;
import br.com.laranja.springcrud.domain.model.Projeto;
import br.com.laranja.springcrud.domain.model.Versao;
import br.com.laranja.springcrud.domain.service.VersaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VersaoController {
    private final VersaoService versaoService;

    @GetMapping("/versao")
    public ResponseEntity<List<Versao>> getAllCollaborator() {
        return ResponseEntity.ok(versaoService.getAllVersao());
    }

    //  get: Listar todos os projeto pelo id
    @GetMapping("/versao/{idVersao}")
    public ResponseEntity<Versao> getVersaoById(@PathVariable Long idVersao) {
        return ResponseEntity.ok(versaoService.getVersaoById(idVersao));
    }

    //  post: Criacao de colaborador
    @PostMapping("/versao")
    public ResponseEntity<Versao> createVersao(@RequestBody VersaoRequest versaoRequest) {
        return ResponseEntity.ok(versaoService.createVersao(versaoRequest));
    }

    //  put: Atualizar colaborador pelo cpf
    @PutMapping("/versao/{idVersao}")
    public ResponseEntity<Versao> updateVersaoById(@PathVariable Long idVersao, @RequestBody VersaoRequest versaoRequest) {
        return ResponseEntity.ok(versaoService.updateVersaoById(idVersao,versaoRequest));
    }

    //  delete: Deletar Collaborator pelo cpf
    @DeleteMapping("/versao/{idVersao}")
    public ResponseEntity deleteVersaoById(@PathVariable Long idVersao) {
        versaoService.deleteByIdVersao(idVersao);
        return ResponseEntity.ok().build();
    }

}
