package br.com.laranja.springcrud.infrastructure.repository;

import br.com.laranja.springcrud.domain.model.TipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoEventoRepository extends JpaRepository<TipoEvento, Long> {
    List<TipoEvento> findAll();  // listar todos banco
    @Override
    Optional<TipoEvento> findById(Long idTipoEvento); // achar pelo Id no banco

    long deleteByIdTipoEvento(Long idTipoEvento); // deletar pelo id
}
