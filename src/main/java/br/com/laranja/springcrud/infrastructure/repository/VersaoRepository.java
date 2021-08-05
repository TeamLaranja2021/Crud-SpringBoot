package br.com.laranja.springcrud.infrastructure.repository;


import br.com.laranja.springcrud.domain.model.Versao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersaoRepository extends JpaRepository<Versao , Long> {
}
