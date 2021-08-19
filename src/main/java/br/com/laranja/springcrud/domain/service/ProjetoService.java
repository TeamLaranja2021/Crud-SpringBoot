package br.com.laranja.springcrud.domain.service;

import br.com.laranja.springcrud.domain.dto.projeto.ProjetoRequest;
import br.com.laranja.springcrud.domain.model.Projeto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProjetoService {

    Page<Projeto> getAllProjetos(Pageable paginacao);

    Projeto getProjetoById(Long idProjeto); // listagem de um projetos pelo id

    Projeto getProjetoByNome(String nome); // listagem de um projetos pelo nome

    Projeto createProjeto(ProjetoRequest projetoRequest); // criação dos projetos

    Projeto updateProjetoById(Long idProjeto, ProjetoRequest projetoRequest); // atualização dos projetos pelo id

    void deleteProjetoById(Long idProjeto); // exclusão dos projetos  pelo id
}
