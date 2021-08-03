package br.com.laranja.springcrud.domain.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tela;

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
