package br.com.laranja.springcrud.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Table(name = "requisicao")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Requisicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_requisicao;

    @ManyToOne(fetch = FetchType.LAZY)
    private Evento id_evento;

    private String url_homolog;
    private String uri_prod;
    private String descricao;
    private int requisicao_pai;
    private String camada;
    private boolean situacao;
    private int  ordem;

}
