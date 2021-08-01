package br.com.laranja.springcrud.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "tela")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTela;
    @ManyToOne(fetch = FetchType.EAGER)
    private Versao id_versao ;
    private LocalDate dataCadastro;
    private String nomeTela;
    private String imagem;
    private boolean situacao;
    private int telaPai;
    private int ordem;
    private String urlLog;
    private int versaoOrigem;

}
