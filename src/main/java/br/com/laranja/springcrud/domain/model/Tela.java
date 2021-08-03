package br.com.laranja.springcrud.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "tela")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTela;

    @ManyToOne(fetch = FetchType.LAZY)
    private Versao versao ;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tela")
    private  List<Evento> evento;


    private LocalDate dataCadastro;
    private String nomeTela;
    private String imagem;
    private boolean situacao;
    private Integer telaPai;
    private Integer ordem;
    private String urlLog;
    private Integer versaoOrigem;

}
