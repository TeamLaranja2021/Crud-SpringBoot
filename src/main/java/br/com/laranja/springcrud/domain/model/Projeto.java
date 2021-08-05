package br.com.laranja.springcrud.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProjeto;
    private String nome;
    private  boolean situacao;

    @OneToMany(mappedBy = "projeto")
    private List<Versao> versoes;
}
