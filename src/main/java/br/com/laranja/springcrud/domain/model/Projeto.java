package br.com.laranja.springcrud.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Table(name = "projeto")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_projeto;
    private String nome;
    private  boolean situacao;
}
