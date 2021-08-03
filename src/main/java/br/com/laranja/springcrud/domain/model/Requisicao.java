package br.com.laranja.springcrud.domain.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Table(name = "requisicao")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Requisicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_requisicao;

    @OneToOne(fetch = FetchType.LAZY)
    private Evento evento;

    private String url_homolog;
    private String uri_prod;
    private String descricao;
    private Integer requisicao_pai;
    private String camada;
    private boolean situacao;
    private Integer  ordem;

}
