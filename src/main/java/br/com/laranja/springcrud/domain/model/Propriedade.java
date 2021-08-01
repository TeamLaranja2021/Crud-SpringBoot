package br.com.laranja.springcrud.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Table(name = "propriedade")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Propriedade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPropriedade;
    @ManyToOne(fetch = FetchType.LAZY)
    private Requisicao idRequisicao;
    private String chave;
    private String valor;
    private int ordem;
}
