package br.com.laranja.springcrud.domain.model;


import javax.persistence.*;
import java.time.LocalDate;


@Table(name = "versao")
@Entity

public class Versao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_versao;
    @ManyToOne(fetch = FetchType.LAZY)
    private Projeto projeto;
    private String gmud;
    private String descricao;
    private LocalDate data_lancamento;
    private boolean situacao;
    private int ordem;
    private String numero_versao;


}
