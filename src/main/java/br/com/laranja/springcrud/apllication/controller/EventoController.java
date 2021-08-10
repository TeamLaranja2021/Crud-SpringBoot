package br.com.laranja.springcrud.apllication.controller;

import br.com.laranja.springcrud.domain.dto.evento.EventoRequest;
import br.com.laranja.springcrud.domain.model.Evento;
import br.com.laranja.springcrud.domain.service.EventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventoController {
    private final EventoService eventoService;

    //  get: Listar todos os eventos
    @GetMapping("/evento")
    public ResponseEntity<List<Evento>> getAllEvento() {
        return ResponseEntity.ok(eventoService.getAllEventos());
    }

    //  get: Listar evento por id
    @GetMapping("/evento/{idEvento}")
    public ResponseEntity<Evento> getEventoById(@PathVariable Long idEvento) {
        return ResponseEntity.ok(eventoService.getEventoById(idEvento));
    }

    //  post: Criacao de evento
    @PostMapping("/evento")
    public ResponseEntity<Evento> createEvento(@RequestBody EventoRequest eventoRequest) {
        return ResponseEntity.ok(eventoService.createEvento(eventoRequest));
    }

    //  put: Atualizar evento by id
    @PutMapping("/evento/{idEvento}")
    public ResponseEntity<Evento> updateEventoById(@PathVariable Long idEvento, @RequestBody EventoRequest eventoRequest) {
        return ResponseEntity.ok(eventoService.updateEventoById(idEvento,eventoRequest));
    }

    //  delete: Deletar evento pelo id
    @DeleteMapping("/evento/{idEvento}")
    public ResponseEntity deleteEventoById(@PathVariable Long idEvento) {
        eventoService.deleteEventoById(idEvento);
        return ResponseEntity.ok().build();
    }

}

