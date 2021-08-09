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
public class Requisicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRequisicao;

    @ManyToOne
    private Evento evento;

    private String urlhomolog;
    private String uriprod;
    private String descricao;
    private Integer requisicaoPai;
    private String camada;
    private boolean situacao;


}
