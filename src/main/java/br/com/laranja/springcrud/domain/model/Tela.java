package br.com.laranja.springcrud.domain.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTela;

    private LocalDate dataCadastro;
    private String nomeTela;
    private String imagem;
    private boolean situacao;
    private Integer telaPai;
    private Integer ordem;
    private String urlLog;
    private Integer versaoOrigem;

    @ManyToOne
    private Versao versao;
}
