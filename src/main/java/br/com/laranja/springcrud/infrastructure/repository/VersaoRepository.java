package br.com.laranja.springcrud.infrastructure.repository;


import br.com.laranja.springcrud.domain.model.Projeto;
import br.com.laranja.springcrud.domain.model.Versao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VersaoRepository extends JpaRepository<Versao , Long> {
    List<Versao> findAll();
    @Override
    Optional<Versao> findById(Long idVersao);

    long deleteByIdVersao(Long idVersao); // deletar pelo id
}
