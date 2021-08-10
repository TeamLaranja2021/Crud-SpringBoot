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
public class Propriedade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPropriedade;



    private String chave;
    private Integer valor;
    private Integer ordem;

    @ManyToOne
    private Requisicao requisicao;
}
