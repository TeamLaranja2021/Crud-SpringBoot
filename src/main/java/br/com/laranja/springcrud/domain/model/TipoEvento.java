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
public class TipoEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipoEvento;

    @OneToOne(fetch = FetchType.LAZY)
    private Evento evento;

    private String nome;
    private boolean situacao;

}
