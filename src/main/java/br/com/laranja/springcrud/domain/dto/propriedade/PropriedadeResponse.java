package br.com.laranja.springcrud.domain.dto.propriedade;

import br.com.laranja.springcrud.domain.dto.evento.EventoResponse;
import br.com.laranja.springcrud.domain.model.Evento;
import br.com.laranja.springcrud.domain.model.Propriedade;
import br.com.laranja.springcrud.domain.model.Requisicao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
public class PropriedadeResponse {
    private Long idPropriedade;
    private String chave;
    private Integer valor;
    private Integer  ordem;

    private Requisicao idRequisicao;


    public PropriedadeResponse(Propriedade propriedade) {
        this.idPropriedade = propriedade.getIdPropriedade();
        this.chave = propriedade.getChave();
        this.valor = propriedade.getValor();
        this.ordem = propriedade.getOrdem();
        this.idRequisicao = propriedade.getRequisicao();
    }

    public static List<PropriedadeResponse> convertList(List<Propriedade> Propriedade) {
        return Propriedade.stream().map(PropriedadeResponse::new).collect(Collectors.toList());
    }
}
