package br.com.laranja.springcrud.apllication.controller;

import br.com.laranja.springcrud.domain.dto.projeto.ProjetoRequest;
import br.com.laranja.springcrud.domain.dto.projeto.ProjetoResponse;
import br.com.laranja.springcrud.domain.model.Projeto;
import br.com.laranja.springcrud.domain.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProjetoController {
    private final ProjetoService projetoService;

    @GetMapping("/projeto")
    public ResponseEntity<Page<ProjetoResponse>> getAllCollaborator(@PageableDefault(sort = "idProjeto", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {
        return ResponseEntity.ok(ProjetoResponse.converter(projetoService.getAllProjetos(paginacao)));
    }

    @GetMapping("/projeto/{nome}")
    public ResponseEntity<Projeto> getProjetoByNome(@PathVariable String nome) {
        if(nome.isEmpty()){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(projetoService.getProjetoByNome(nome));

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

