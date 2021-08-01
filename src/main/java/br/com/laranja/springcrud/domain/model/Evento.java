package br.com.laranja.springcrud.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Table(name = "evento")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_evento;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipoEvento tipoEvento;

    @ManyToOne(fetch = FetchType.EAGER)
    private Tela tela;
    private boolean situacao;
    private int ordem;
    private String parametros;
}
