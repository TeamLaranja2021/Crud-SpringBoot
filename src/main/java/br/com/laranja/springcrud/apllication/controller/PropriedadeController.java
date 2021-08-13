package br.com.laranja.springcrud.apllication.controller;


import br.com.laranja.springcrud.domain.dto.evento.EventoResponse;
import br.com.laranja.springcrud.domain.dto.propriedade.PropriedadeRequest;
import br.com.laranja.springcrud.domain.dto.propriedade.PropriedadeResponse;
import br.com.laranja.springcrud.domain.model.Propriedade;
import br.com.laranja.springcrud.domain.service.PropriedadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class PropriedadeController {
    private final PropriedadeService propriedadeService;


    @GetMapping("/propriedade")
    public ResponseEntity<List<PropriedadeResponse>> getAllPropriedades() {
        return ResponseEntity.ok(PropriedadeResponse.convertList(propriedadeService.getAllPropriedades()));
    }


    @GetMapping("/propriedade/{idPropriedade}")
    public ResponseEntity<Propriedade> getPropriedadeById(@PathVariable Long idPropriedade) {
        return ResponseEntity.ok(propriedadeService.getPropriedadeById(idPropriedade));
    }



    @PostMapping("/propriedade")
    public ResponseEntity<Propriedade> createPropriedade (@RequestBody PropriedadeRequest propriedadeRequest) {
        return  ResponseEntity.ok(propriedadeService.createPropriedade(propriedadeRequest));
    }


    @PutMapping("/propriedade/{idPropriedade}")
    public ResponseEntity<Propriedade> updatePropriedadeById(@PathVariable Long idPropriedade, @RequestBody PropriedadeRequest propriedadeRequest) {
        return ResponseEntity.ok(propriedadeService.updatePropriedadeId(idPropriedade,propriedadeRequest));
    }


    @DeleteMapping("/propriedade/{idPropriedade}")
    public ResponseEntity deletePropriedadeById(@PathVariable Long idPropriedade) {
        propriedadeService.deletePropriedadeById(idPropriedade);
        return ResponseEntity.ok().build();
    }
}
