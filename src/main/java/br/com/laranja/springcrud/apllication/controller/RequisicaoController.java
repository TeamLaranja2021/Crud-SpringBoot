package br.com.laranja.springcrud.apllication.controller;

import br.com.laranja.springcrud.domain.dto.RequisicaoRequest;
import br.com.laranja.springcrud.domain.model.Requisicao;
import br.com.laranja.springcrud.domain.service.RequisicaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class RequisicaoController {
    private final RequisicaoService requisicaoService;


    @GetMapping("/requisicao")
    public ResponseEntity<List<Requisicao>> getAllRequisicao(){
        return  ResponseEntity.ok(requisicaoService.getAllRequisicao());
    }

    @GetMapping("/requisicao/{idRequisicao}")
    public ResponseEntity<Requisicao> getRequisicaoById(@PathVariable Long idRequisicao ){
        return  ResponseEntity.ok(requisicaoService.getRequisicaoById(idRequisicao));
    }

    @PostMapping("/requisicao")
    public ResponseEntity<Requisicao> requisicaoTela (@RequestBody RequisicaoRequest requisicaoRequest) {
        return  ResponseEntity.ok(requisicaoService.createRequiscao(requisicaoRequest));
    }

    @PutMapping("/requisicao/{idRequisicao}")
    public ResponseEntity<Requisicao> updateRequisicaoById(@PathVariable Long idRequisicao, @RequestBody RequisicaoRequest requisicaoRequest) {
        return ResponseEntity.ok(requisicaoService.updateRequisicaoId(idRequisicao,requisicaoRequest));
    }



    @DeleteMapping("/requisicao/{idRequisicao}")
    public ResponseEntity deleteRequisicaoById(@PathVariable Long idRequisicao) {
        requisicaoService.deleteRequisicaoById(idRequisicao);
        return ResponseEntity.ok().build();
    }



}
