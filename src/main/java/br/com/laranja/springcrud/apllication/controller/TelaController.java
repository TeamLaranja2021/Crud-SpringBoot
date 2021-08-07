package br.com.laranja.springcrud.apllication.controller;

import br.com.laranja.springcrud.domain.dto.TelaRequest;
import br.com.laranja.springcrud.domain.model.Tela;
import br.com.laranja.springcrud.domain.service.TelaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class TelaController {
    private final TelaService telaService;

    @GetMapping("/tela")
    public ResponseEntity<List<Tela>> getAllTela() {
        return ResponseEntity.ok(telaService.getAllTelas());
    }


    @GetMapping("/tela/{idTela}")
    public ResponseEntity<Tela> getTelaById(@PathVariable Long idTela) {
        return ResponseEntity.ok(telaService.getTelaById(idTela));
    }


    @PostMapping("/tela")
    public ResponseEntity<Tela> createTela (@RequestBody TelaRequest telaRequest) {
        return  ResponseEntity.ok(telaService.createTela(telaRequest));
    }


    @PutMapping("/tela/{idTela}")
    public ResponseEntity<Tela> updateTelaById(@PathVariable Long idTela, @RequestBody TelaRequest telaRequest) {
        return ResponseEntity.ok(telaService.updateTelaId(idTela,telaRequest));
    }


    @DeleteMapping("/tela/{idTela}")
    public ResponseEntity deleteTelaById(@PathVariable Long idTela) {
        telaService.deleteTelaById(idTela);
        return ResponseEntity.ok().build();
    }

}
