package br.com.laranja.springcrud.domain.service.impl;


import br.com.laranja.springcrud.domain.dto.evento.EventoRequest;
import br.com.laranja.springcrud.domain.model.*;
import br.com.laranja.springcrud.domain.service.EventoService;
import br.com.laranja.springcrud.infrastructure.exception.*;
import br.com.laranja.springcrud.infrastructure.repository.EventoRepository;
import br.com.laranja.springcrud.infrastructure.repository.TelaRepository;

import br.com.laranja.springcrud.infrastructure.repository.TipoEventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventoServiceImpl implements EventoService {
    private final EventoRepository eventoRepository;
    private final TelaRepository telaRepository;
    private final TipoEventoRepository tipoEventoRepository;

    @Override
    public List<Evento> getAllEventos() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento getEventoById(Long idEvento) {
        return eventoRepository.findById(idEvento).orElseThrow(() -> new EventoNotFoundException(idEvento));
    }

    @Override
    public Evento createEvento(EventoRequest eventoRequest) {

        Optional<Tela> Optionaltela = telaRepository.findById(eventoRequest.getTela());

        if (Optionaltela.isEmpty()) {
            throw new TelaNotFoundException(eventoRequest.getTela());
        }

        Optional<TipoEvento> Optionaltipoevento = tipoEventoRepository.findById(eventoRequest.getTipoEvento());

        if (Optionaltipoevento.isEmpty()) {
            throw new TipoEventoNotFoundException(eventoRequest.getTipoEvento());
        }

        Evento evento = Evento.builder()
                .situacao(eventoRequest.isSituacao())
                .ordem(eventoRequest.getOrdem())
                .parametros(eventoRequest.getParametros())
                .tela(Optionaltela.get())
                .tipoEvento(Optionaltipoevento.get())

                .build();
        return eventoRepository.save(evento);
    }

    @Override
    public Evento updateEventoById(Long idEvento, EventoRequest eventoRequest) {

        Optional<Tela> Optionaltela = telaRepository.findById(eventoRequest.getTela());

        if (Optionaltela.isEmpty()) {
            throw new TelaNotFoundException(eventoRequest.getTela());
        }

        Optional<TipoEvento> Optionaltipoevento = tipoEventoRepository.findById(eventoRequest.getTipoEvento());

        if (Optionaltipoevento.isEmpty()) {
            throw new TipoEventoNotFoundException(eventoRequest.getTipoEvento());
        }

        Optional<Evento> Optionalevento = eventoRepository.findById(idEvento);

        if (Optionalevento.isEmpty()) {
            throw new EventoNotFoundException(idEvento);
        }

        Evento eventoExistente = Optionalevento.get();

        return eventoRepository.save(Evento.builder()
                .idEvento(eventoExistente.getIdEvento())
                .situacao(eventoRequest.isSituacao())
                .ordem(eventoRequest.getOrdem())
                .parametros(eventoRequest.getParametros())
                .tela(Optionaltela.get())
                .tipoEvento(Optionaltipoevento.get())

                .build());

    }

    @Transactional
    @Override
    public void deleteEventoById(Long idEvento) throws EventoNotFoundException {
        Optional<Evento> evento = Optional.ofNullable(this.getEventoById(idEvento));
        if (!evento.isPresent()){
            throw new EventoNotFoundException(idEvento);
        }
        eventoRepository.deleteByIdEvento(idEvento);
    }
}
