package br.com.laranja.springcrud.apllication.controller;

import br.com.laranja.springcrud.domain.dto.requiscao.RequisicaoResponse;
import br.com.laranja.springcrud.domain.dto.tipoEvento.TipoEventoRequest;
import br.com.laranja.springcrud.domain.dto.tipoEvento.TipoEventoResponse;
import br.com.laranja.springcrud.domain.model.TipoEvento;
import br.com.laranja.springcrud.domain.service.TipoEventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TipoEventoController {
    private final TipoEventoService tipoeventoService;

    @GetMapping("/tipoevento")
    public ResponseEntity<List<TipoEventoResponse>> getAllTipoEvento() {
        return ResponseEntity.ok(TipoEventoResponse.convertList(tipoeventoService.getAllTipoEventos()));
    }

    //  get: Listar todos os tipos de eventos
    @GetMapping("/tipoevento/{idTipoEvento}")
    public ResponseEntity<TipoEventoResponse> getTipoEventoById(@PathVariable Long idTipoEvento) {
        TipoEventoResponse tipoEventoResponse = new TipoEventoResponse(tipoeventoService.getTipoEventoById(idTipoEvento));
        return ResponseEntity.ok(tipoEventoResponse);
    }

    //  post: Criacao de tipo de evento
    @PostMapping("/tipoevento")
    public ResponseEntity<TipoEvento> createTipoEvento(@RequestBody TipoEventoRequest tipoeventoRequest) {
        return ResponseEntity.ok(tipoeventoService.createTipoEvento(tipoeventoRequest));
    }

    //  put: Atualizar tipo de evento by id
    @PutMapping("/tipoevento/{idTipoEvento}")
    public ResponseEntity<TipoEvento> updateTipoEventoById(@PathVariable Long idTipoEvento, @RequestBody TipoEventoRequest tipoeventoRequest) {
        return ResponseEntity.ok(tipoeventoService.updateTipoEventoById(idTipoEvento,tipoeventoRequest));
    }

    //  delete: Deletar tipo de evento pelo id
    @DeleteMapping("/tipoevento/{idTipoEvento}")
    public ResponseEntity deleteTipoEventoById(@PathVariable Long idTipoEvento) {
        tipoeventoService.deleteTipoEventoById(idTipoEvento);
        return ResponseEntity.ok().build();
    }

}

