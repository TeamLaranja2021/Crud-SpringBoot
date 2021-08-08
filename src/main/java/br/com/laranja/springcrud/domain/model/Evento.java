package br.com.laranja.springcrud.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvento;
    private Boolean situacao;
    private Integer ordem;
    private String parametros;
    @ManyToOne
    private Tela tela;
    @ManyToOne
    private TipoEvento tipoEvento;
    @OneToMany(mappedBy = "evento")
    private List<Requisicao> requisicao;
}
