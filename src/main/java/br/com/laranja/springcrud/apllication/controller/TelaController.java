package br.com.laranja.springcrud.apllication.controller;

import br.com.laranja.springcrud.domain.dto.tela.TelaRequest;
import br.com.laranja.springcrud.domain.dto.tela.TelaResponse;
import br.com.laranja.springcrud.domain.dto.tipoEvento.TipoEventoResponse;
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
    public ResponseEntity<List<TelaResponse>> getAllTela() {
        return ResponseEntity.ok(TelaResponse.convertList(telaService.getAllTelas()));
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
