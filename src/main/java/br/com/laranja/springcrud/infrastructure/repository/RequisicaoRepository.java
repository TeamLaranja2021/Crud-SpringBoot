package br.com.laranja.springcrud.infrastructure.repository;

import br.com.laranja.springcrud.domain.model.Requisicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequisicaoRepository extends JpaRepository<Requisicao, Long> {
    List<Requisicao> findAll();

    @Override
    Optional<Requisicao> findById(Long idRequisicao);

    long deleteByIdRequisicao(Long idRequisicao);
}
