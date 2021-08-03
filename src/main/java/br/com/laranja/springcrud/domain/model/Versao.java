package br.com.laranja.springcrud.domain.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Table(name = "versao")
@Entity
public class Versao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_versao;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "versao")
    private List<Tela> tela;


    private String gmud;
    private String descricao;
    private LocalDate data_lancamento;
    private boolean situacao;
    private Integer ordem;
    private String numero_versao;


}
