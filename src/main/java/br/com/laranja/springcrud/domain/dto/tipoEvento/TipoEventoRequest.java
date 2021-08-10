package br.com.laranja.springcrud.domain.dto.tipoEvento;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TipoEventoRequest {
    private Long idTipoEvento;
    private String nome;
    private boolean situacao;

}
