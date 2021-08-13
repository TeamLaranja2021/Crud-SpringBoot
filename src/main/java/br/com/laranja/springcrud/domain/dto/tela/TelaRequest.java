package br.com.laranja.springcrud.domain.dto.tela;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class TelaRequest {
    private Long idtela;
    private LocalDate dataCadastro;
    private String nomeTela;
    private String imagem;
    private boolean situacao;
    private Integer telaPai;
    private Integer ordem;
    private String urlLog;
    private Integer versaoOrigem;
    private Long idVersao;
}
