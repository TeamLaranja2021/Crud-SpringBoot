package br.com.laranja.springcrud.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Table(name = "evento")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_evento;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipoEvento id_tipoEvento;

    @ManyToOne(fetch = FetchType.EAGER)
    private Tela idtela;
    private boolean situacao;
    private int ordem;
    private String parametros;
}
