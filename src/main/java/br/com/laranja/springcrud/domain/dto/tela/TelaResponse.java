package br.com.laranja.springcrud.domain.dto.tela;

import br.com.laranja.springcrud.domain.dto.requiscao.RequisicaoResponse;
import br.com.laranja.springcrud.domain.model.Requisicao;
import br.com.laranja.springcrud.domain.model.Tela;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
public class TelaResponse {
    private Long idtela;
    private LocalDate dataCadastro;
    private String nomeTela;
    private String imagem;
    private boolean situacao;
    private Integer telaPai;
    private Integer ordem;
    private String urlLog;
    private Integer versaoOrigem;
    private Long idVersao;


    public TelaResponse(Tela tela) {
        this.idtela = tela.getIdTela();
        this.dataCadastro = tela.getDataCadastro();
        this.nomeTela = tela.getNomeTela();
        this.imagem = tela.getImagem();
        this.situacao = tela.isSituacao();
        this.telaPai = tela.getTelaPai();
        this.ordem = tela.getOrdem();
        this.urlLog = tela.getUrlLog();
        this.versaoOrigem = tela.getVersaoOrigem();
        this.idVersao = tela.getIdTela();
    }

    public static List<TelaResponse> convertList(List<Tela> Tela) {
        return Tela.stream().map(TelaResponse::new).collect(Collectors.toList());
    }
}
