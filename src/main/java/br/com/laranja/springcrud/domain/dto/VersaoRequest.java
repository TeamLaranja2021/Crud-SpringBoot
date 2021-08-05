package br.com.laranja.springcrud.domain.dto;


import br.com.laranja.springcrud.domain.model.Projeto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class VersaoRequest {
    private Long id;
    private String gmud;
    private String descricao;
    private LocalDate dataLancamento;
    private Boolean situacao;
    private Integer ordem;
    private String numeroVersao;
   // private Long projetoId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Projeto projeto;

}
