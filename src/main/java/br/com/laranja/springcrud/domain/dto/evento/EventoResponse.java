package br.com.laranja.springcrud.domain.dto.evento;

import br.com.laranja.springcrud.domain.dto.versao.VersaoResponse;
import br.com.laranja.springcrud.domain.model.Evento;
import br.com.laranja.springcrud.domain.model.Tela;
import br.com.laranja.springcrud.domain.model.TipoEvento;
import br.com.laranja.springcrud.domain.model.Versao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Builder
public class EventoResponse {
    private Long idEvento;
    private boolean situacao;
    private Integer ordem;
    private String parametros;
    private TipoEvento tipoEvento;
    private Tela tela;



    public EventoResponse(Evento evento) {
        this.idEvento = evento.getIdEvento();
        this.situacao = evento.getSituacao();
        this.ordem = evento.getOrdem();
        this.parametros = evento.getParametros();
        this.tipoEvento = evento.getTipoEvento();
        this.tela = evento.getTela();

    }
    public static List<EventoResponse> convertList(List<Evento> Evento) {
        return Evento.stream().map(EventoResponse::new).collect(Collectors.toList());
    }
}
