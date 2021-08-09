package br.com.laranja.springcrud.infrastructure.repository;

import br.com.laranja.springcrud.domain.dto.UsuarioRequest;
import br.com.laranja.springcrud.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findAll();  // listar todos banco
    Optional<Usuario> findById(Long idUsuario); // achar pelo Id no banco
    void deleteById(Long idUsuario); // deletar pelo id

}
