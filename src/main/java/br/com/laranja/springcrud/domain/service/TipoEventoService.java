package br.com.laranja.springcrud.domain.service;

import br.com.laranja.springcrud.domain.dto.tipoEvento.TipoEventoRequest;
import br.com.laranja.springcrud.domain.model.TipoEvento;

import java.util.List;

public interface TipoEventoService {

    List<TipoEvento> getAllTipoEventos();

    TipoEvento getTipoEventoById(Long idTipoEvento); // listagem de um evento pelo id

    TipoEvento createTipoEvento(TipoEventoRequest tipoeventoRequest); // criação dos eventos

    TipoEvento updateTipoEventoById(Long idTipoEvento, TipoEventoRequest tipoeventoRequest); // atualização dos eventos pelo id

    void deleteTipoEventoById(Long idTipoEvento); // exclusão dos eventos  pelo id
}
