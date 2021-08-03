package br.com.laranja.springcrud.domain.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Propriedade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_propriedade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Requisicao requisicao;

    private String chave;
    private String valor;
    private Integer ordem;
}
