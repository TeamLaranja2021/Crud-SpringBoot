package br.com.laranja.springcrud.infrastructure.repository;

import br.com.laranja.springcrud.domain.model.Tela;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TelaRepository extends JpaRepository<Tela, Long> {
    List<Tela> findAll();  // listar todos banco
    Optional<Tela> findById(Long idTela); // achar pelo Id no banco
    long deleteByIdTela(Long idTela); // deletar pelo id
}
