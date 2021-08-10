package br.com.laranja.springcrud.domain.dto.requiscao;

import br.com.laranja.springcrud.domain.dto.projeto.ProjetoResponse;
import br.com.laranja.springcrud.domain.model.Evento;
import br.com.laranja.springcrud.domain.model.Projeto;
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
public class RequisicaoResponse {
    private Long idRequisicao;
    private String urlhomolog;
    private String uriprod;
    private String descricao;
    private Integer requisicaoPai;
    private String camada;
    private boolean situacao;
    private Evento idEvento;


    public RequisicaoResponse(Requisicao requisicao) {
        this.idRequisicao = requisicao.getIdRequisicao();
        this.urlhomolog = requisicao.getUrlhomolog();
        this.uriprod = requisicao.getUriprod();
        this.descricao = requisicao.getDescricao();
        this.requisicaoPai = requisicao.getRequisicaoPai();
        this.camada = requisicao.getCamada();
        this.situacao = requisicao.isSituacao();
        this.idEvento = requisicao.getEvento();
    }
    public static List<RequisicaoResponse> convertList(List<Requisicao> Requisicao) {
        return Requisicao.stream().map(RequisicaoResponse::new).collect(Collectors.toList());
    }
}
