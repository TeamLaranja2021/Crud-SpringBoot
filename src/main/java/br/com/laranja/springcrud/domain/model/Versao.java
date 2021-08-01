package br.com.laranja.springcrud.domain.model;


import javax.persistence.*;
import java.time.LocalDate;


@Table(name = "versao")
@Entity

public class Versao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_versao;
    @ManyToOne
    @JoinColumn(name = "id_projeto")
    private Projeto id_projeto;
    private String gmud;
    private String descricao;
    private LocalDate data_lancamento;
    private boolean situacao;
    private int ordem;
    private String numero_versao;


}
