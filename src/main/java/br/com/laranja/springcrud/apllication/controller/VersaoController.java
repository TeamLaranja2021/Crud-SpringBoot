package br.com.laranja.springcrud.apllication.controller;


import br.com.laranja.springcrud.domain.dto.versao.VersaoForm;
import br.com.laranja.springcrud.domain.dto.versao.VersaoRequest;
import br.com.laranja.springcrud.domain.dto.versao.VersaoResponse;
import br.com.laranja.springcrud.domain.model.Versao;
import br.com.laranja.springcrud.domain.service.VersaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class VersaoController {
    private final VersaoService versaoService;

    @GetMapping("/versao")
    public ResponseEntity<List<VersaoResponse>> getAllCollaborator() {
        return ResponseEntity.ok(VersaoResponse.convertList(versaoService.getAllVersao()));
    }


    @GetMapping("/versao/{idVersao}")
    public ResponseEntity<VersaoResponse> getVersaoById(@PathVariable Long idVersao) {
        return ResponseEntity.ok(new VersaoResponse(versaoService.getVersaoById(idVersao)));
    }


    @PostMapping("/versao")
    public ResponseEntity<Versao> createVersao(@Valid @RequestBody VersaoForm versaoform) {
        return ResponseEntity.ok(versaoService.createVersao(versaoform));
    }

    @PutMapping("/versao/{idVersao}")
    public ResponseEntity<Versao> updateVersaoById(@PathVariable Long idVersao, @RequestBody VersaoRequest versaoRequest) {
        return ResponseEntity.ok(versaoService.updateVersaoById(idVersao,versaoRequest));
    }


    @DeleteMapping("/versao/{idVersao}")
    public ResponseEntity deleteVersaoById(@PathVariable Long idVersao) {
        versaoService.deleteByIdVersao(idVersao);
        return ResponseEntity.ok().build();
    }

}
