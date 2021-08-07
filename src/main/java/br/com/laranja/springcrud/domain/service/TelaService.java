package br.com.laranja.springcrud.domain.service;
import br.com.laranja.springcrud.domain.dto.TelaRequest;
import br.com.laranja.springcrud.domain.model.Tela;


import java.util.List;

public interface TelaService {

    List<Tela> getAllTelas();

    Tela getTelaById(Long idTela); // pega 1 usuario pelo id

    Tela createTela(TelaRequest telaRequest); // criação dos projetos

    Tela updateTelaId(Long idTela, TelaRequest telaRequest); // atualização dos projetos pelo id

    void deleteTelaById(Long idTela); // deletar usuario pelo id
}
