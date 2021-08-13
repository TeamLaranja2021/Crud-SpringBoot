package br.com.laranja.springcrud.domain.dto.versao;

import br.com.laranja.springcrud.domain.model.Projeto;
import br.com.laranja.springcrud.domain.model.Tela;
import br.com.laranja.springcrud.domain.model.Versao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Builder
public class VersaoResponse {
    private Long idversao;

    private String gmud;
    private String descricao;
    private LocalDate dataLancamento;
    private Boolean situacao;
    private Integer ordem;
    private String numeroVersao;
    @ManyToOne
    private Projeto projeto;

public VersaoResponse(Versao versao){
    this.idversao = versao.getIdVersao();
    this.gmud = versao.getGmud();
    this.descricao = versao.getDescricao();
    this.dataLancamento = versao.getDataLancamento();
    this.situacao = versao.getSituacao();
    this.ordem = versao.getOrdem();
    this.numeroVersao = versao.getNumeroVersao();
    this.projeto = versao.getProjeto();
}

    public static List<VersaoResponse> convertList(List<Versao> Versao) {
        return Versao.stream().map(VersaoResponse::new).collect(Collectors.toList());
    }
}
