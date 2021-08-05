package br.com.laranja.springcrud.domain.dto;

import br.com.laranja.springcrud.domain.model.Versao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ProjetoRequest {
    private Long idProjeto;
    private String nome;
    private  boolean situacao;
    private List<Versao> versoes;
}
