package br.com.laranja.springcrud.infrastructure.repository;

import br.com.laranja.springcrud.domain.model.Loger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Loger, Long> {
}
