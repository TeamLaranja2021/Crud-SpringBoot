package br.com.laranja.springcrud.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Versao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVersao;
    private String gmud;
    private String descricao;
    private LocalDate dataLancamento;
    private Boolean situacao;
    private Integer ordem;
    private String numeroVersao;

    @ManyToOne
    private Projeto projeto;


}
