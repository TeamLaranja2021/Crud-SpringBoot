package br.com.laranja.springcrud.domain.service.impl;


import br.com.laranja.springcrud.domain.dto.tipoEvento.TipoEventoRequest;
import br.com.laranja.springcrud.domain.dto.tipoEvento.TipoEventoResponse;
import br.com.laranja.springcrud.domain.model.Evento;
import br.com.laranja.springcrud.domain.model.Projeto;
import br.com.laranja.springcrud.domain.model.TipoEvento;
import br.com.laranja.springcrud.domain.model.Versao;
import br.com.laranja.springcrud.domain.service.TipoEventoService;
import br.com.laranja.springcrud.infrastructure.exception.EntityWithDependentsException;
import br.com.laranja.springcrud.infrastructure.exception.EventoNotFoundException;
import br.com.laranja.springcrud.infrastructure.exception.TipoEventoNotFoundException;
import br.com.laranja.springcrud.infrastructure.exception.VersaoNotFoundException;
import br.com.laranja.springcrud.infrastructure.repository.EventoRepository;
import br.com.laranja.springcrud.infrastructure.repository.TipoEventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoEventoServiceImpl implements TipoEventoService {
    private final TipoEventoRepository tipoeventoRepository;
    private final EventoRepository eventoRepository;

    @Override
    @Cacheable(value = "tipoEvento")
    public List<TipoEvento> getAllTipoEventos() {
        return tipoeventoRepository.findAll();
    }

    @Override
    @CacheEvict(value = "tipoEvento", allEntries = true)
    public TipoEvento getTipoEventoById(Long idTipoEvento) {
        return tipoeventoRepository.findById(idTipoEvento).orElseThrow(() -> new EventoNotFoundException(idTipoEvento));
    }

    @Override
    @CacheEvict(value = "tipoEvento", allEntries = true)
    public TipoEvento createTipoEvento(TipoEventoRequest tipoEventoRequest) {
        TipoEvento tipoevento = TipoEvento.builder()
                .situacao(tipoEventoRequest.isSituacao())
                .nome(tipoEventoRequest.getNome())

                .build();
        return tipoeventoRepository.save(tipoevento);
    }

    @Override
    @CacheEvict(value = "tipoEvento", allEntries = true)
    public TipoEvento updateTipoEventoById(Long idTipoEvento, TipoEventoRequest tipoEventoRequest) {
        Optional<TipoEvento> TipoEventoOpcional = tipoeventoRepository.findById(idTipoEvento);

        if (!TipoEventoOpcional.isPresent()) {
            throw new TipoEventoNotFoundException(idTipoEvento);
        }
        TipoEvento eventoExistente = TipoEventoOpcional.get();
        return tipoeventoRepository.save(eventoExistente.builder()
                .idTipoEvento(eventoExistente.getIdTipoEvento())
                .situacao(tipoEventoRequest.isSituacao())
                .nome(tipoEventoRequest.getNome())
                .build());

    }


    @Transactional
    @Override
    @CacheEvict(value = "tipoEvento", allEntries = true)
    public void deleteTipoEventoById(Long id) throws RuntimeException {
        Optional<TipoEvento> tipoEventoOptional = Optional.ofNullable(this.getTipoEventoById(id));
        if (!tipoEventoOptional.isPresent()){
            throw new TipoEventoNotFoundException(id);
        }

        tipoeventoRepository.deleteByIdTipoEvento(id);
    }
}
