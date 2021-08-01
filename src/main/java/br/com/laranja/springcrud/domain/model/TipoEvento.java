package br.com.laranja.springcrud.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Table(name = "tipo_evento")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class TipoEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_evento;
    private String nome;
    private boolean situacao;

}
