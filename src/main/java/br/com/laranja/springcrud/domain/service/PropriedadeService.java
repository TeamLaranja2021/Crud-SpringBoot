package br.com.laranja.springcrud.domain.service;

import br.com.laranja.springcrud.domain.dto.propriedade.PropriedadeRequest;
import br.com.laranja.springcrud.domain.model.Propriedade;

import java.util.List;

public interface PropriedadeService {

    List<Propriedade> getAllPropriedades();

    Propriedade getPropriedadeById(Long idPropriedade);

    Propriedade createPropriedade(PropriedadeRequest propriedadeRequest);

    Propriedade updatePropriedadeId(Long idPropriedade, PropriedadeRequest propriedadeRequest);

    void deletePropriedadeById(Long idPropriedade);

}
