package br.com.laranja.springcrud.domain.dto.propriedade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PropriedadeRequest {
    private Long idPropriedade;
    private String chave;
    private Integer valor;
    private Integer  ordem;
    private Long idRequisicao;
}
