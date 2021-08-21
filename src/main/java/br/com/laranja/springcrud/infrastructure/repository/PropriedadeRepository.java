package br.com.laranja.springcrud.infrastructure.repository;

import br.com.laranja.springcrud.domain.model.Propriedade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropriedadeRepository extends JpaRepository<Propriedade, Long> {
    List<Propriedade> findAll();

    @Override
    Optional<Propriedade> findById(Long idPropriedade);

    long deleteByIdPropriedade(Long idPropriedade);

    List<Propriedade> findAllByRequest_Id(Long idRequisicao);
}
