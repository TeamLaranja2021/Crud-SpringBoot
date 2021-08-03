package br.com.laranja.springcrud.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Table(name = "evento")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)

public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_evento;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipoEvento tipoEvento;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tela tela;

    private boolean situacao;
    private Integer ordem;
    private String parametros;
}
