package br.com.laranja.springcrud.infrastructure.repository;

import br.com.laranja.springcrud.domain.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findAll();  // listar todos banco
    Optional<Evento> findById(Long idEvento); // achar pelo Id no banco

    long deleteByIdEvento(Long idEvento); // deletar pelo id

}
