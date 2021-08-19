package br.com.laranja.springcrud.infrastructure.repository;

import br.com.laranja.springcrud.domain.model.Projeto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    @Override
    Optional<Projeto> findById(Long idProjeto);

    Optional<Projeto> findByNome(String nome);

    long deleteByIdProjeto(Long idProjeto); // deletar pelo id

}
