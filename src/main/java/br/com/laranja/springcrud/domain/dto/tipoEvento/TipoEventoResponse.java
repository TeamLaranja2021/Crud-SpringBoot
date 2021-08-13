package br.com.laranja.springcrud.domain.dto.tipoEvento;

import br.com.laranja.springcrud.domain.model.Evento;
import br.com.laranja.springcrud.domain.model.TipoEvento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
public class TipoEventoResponse {
    private Long idTipoEvento;
    private String nome;
    private boolean situacao;
    private List<Evento> evento;


    public TipoEventoResponse(TipoEvento tipoEvento) {
        this.idTipoEvento = tipoEvento.getIdTipoEvento();
        this.nome = tipoEvento.getNome();
        this.situacao = tipoEvento.getSituacao();
    }

    public static List<TipoEventoResponse> convertList(List<TipoEvento> TipoEvento) {
        return TipoEvento.stream().map(TipoEventoResponse::new).collect(Collectors.toList());
    }
}
