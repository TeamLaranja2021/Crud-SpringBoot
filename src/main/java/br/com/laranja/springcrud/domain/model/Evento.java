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
    private Long id_evento;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipoEvento tipoEvento;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tela tela;

    private boolean situacao;
    private Integer ordem;
    private String parametros;
}
