package br.com.laranja.springcrud.domain.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;



@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Versao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_versao;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "versao")
    private List<Tela> tela;

    @ManyToOne(fetch = FetchType.LAZY)
    private Projeto projeto;


    private String gmud;
    private String descricao;
    private LocalDate data_lancamento;
    private boolean situacao;
    private Integer ordem;
    private String numero_versao;


}
