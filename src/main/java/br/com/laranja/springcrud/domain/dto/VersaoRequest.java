package br.com.laranja.springcrud.domain.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDate;


@Data
@AllArgsConstructor
@Builder
public class VersaoRequest {
    private Long idversao;

    private String gmud;
    private String descricao;
    private LocalDate dataLancamento;
    private Boolean situacao;
    private Integer ordem;
    private String numeroVersao;
    private Long idProjeto;

}
