package br.com.laranja.springcrud.infrastructure.repository;

import br.com.laranja.springcrud.domain.model.Projeto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends CrudRepository<Projeto, Long> {
}
