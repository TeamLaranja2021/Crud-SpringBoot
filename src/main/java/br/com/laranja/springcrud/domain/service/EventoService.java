package br.com.laranja.springcrud.domain.service;

import br.com.laranja.springcrud.domain.dto.evento.EventoRequest;
import br.com.laranja.springcrud.domain.model.Evento;

import java.util.List;

public interface EventoService {

    List<Evento> getAllEventos();

    Evento getEventoById(Long idEvento); // listagem de um evento pelo id

    Evento createEvento(EventoRequest eventoRequest); // criação dos eventos

    Evento updateEventoById(Long idEvento, EventoRequest eventoRequest); // atualização dos eventos pelo id

    void deleteEventoById(Long idEvento); // exclusão dos eventos  pelo id
}
