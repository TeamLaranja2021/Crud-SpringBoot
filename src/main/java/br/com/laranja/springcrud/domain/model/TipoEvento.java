package br.com.laranja.springcrud.domain.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class TipoEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoEvento;
    private String nome;
    private Boolean situacao;

    @OneToMany(mappedBy = "tipoEvento")
    @JsonIgnore
    private List<Evento> evento;


}
