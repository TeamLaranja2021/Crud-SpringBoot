package br.com.laranja.springcrud.domain.dto.projeto;


import br.com.laranja.springcrud.domain.dto.evento.EventoResponse;
import br.com.laranja.springcrud.domain.model.Evento;
import br.com.laranja.springcrud.domain.model.Projeto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Builder
public class ProjetoResponse {
    private Long idProjeto;
    private String nome;
    private boolean situacao;


    public ProjetoResponse(Projeto projeto) {
        this.idProjeto = projeto.getIdProjeto();
        this.nome = projeto.getNome();
        this.situacao = projeto.isSituacao();
    }
    public static List<ProjetoResponse> convertList(List<Projeto> Projeto) {
        return Projeto.stream().map(ProjetoResponse::new).collect(Collectors.toList());
    }

    public static Page<ProjetoResponse> converter(Page<Projeto> projetos) {
        return projetos.map(ProjetoResponse::new);
    }
}
