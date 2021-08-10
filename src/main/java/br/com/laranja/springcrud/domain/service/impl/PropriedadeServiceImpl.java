package br.com.laranja.springcrud.domain.service.impl;

import br.com.laranja.springcrud.domain.dto.propriedade.PropriedadeRequest;
import br.com.laranja.springcrud.domain.model.Propriedade;
import br.com.laranja.springcrud.domain.model.Requisicao;
import br.com.laranja.springcrud.domain.service.PropriedadeService;
import br.com.laranja.springcrud.infrastructure.exception.PropriedadeNotFoundException;
import br.com.laranja.springcrud.infrastructure.exception.RequisicaoNotFoundException;
import br.com.laranja.springcrud.infrastructure.repository.PropriedadeRepository;
import br.com.laranja.springcrud.infrastructure.repository.RequisicaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PropriedadeServiceImpl implements PropriedadeService {
    private final PropriedadeRepository propriedadeRepository;
    private final RequisicaoRepository requisicaoRepository;

    @Override
    public List<Propriedade> getAllPropriedades() {
        return propriedadeRepository.findAll();
    }

    @Override
    public Propriedade getPropriedadeById(Long idPropriedade) {
        return propriedadeRepository.findById(idPropriedade).orElseThrow( () -> new PropriedadeNotFoundException(idPropriedade));
    }

    @Override
    public Propriedade createPropriedade(PropriedadeRequest propriedadeRequest) {
        Optional<Requisicao> Optionalpropriedade = requisicaoRepository.findById(propriedadeRequest.getIdRequisicao());

        if (Optionalpropriedade.isEmpty() ){
            throw  new RequisicaoNotFoundException(propriedadeRequest.getIdRequisicao());
        }

       Propriedade propriedade = Propriedade.builder()
               .chave(propriedadeRequest.getChave())
               .valor(propriedadeRequest.getValor())
               .ordem(propriedadeRequest.getOrdem())
               .requisicao(Optionalpropriedade.get())
               .build();
        return propriedadeRepository.save(propriedade);
    }

    @Override
    public Propriedade updatePropriedadeId(Long idPropriedade, PropriedadeRequest propriedadeRequest) {
        Optional<Propriedade> PropriedadeOptional = propriedadeRepository.findById(idPropriedade);

        if (!PropriedadeOptional.isPresent()) {
            throw new PropriedadeNotFoundException(idPropriedade);
        }

        Optional<Requisicao> Optionalpropriedade = requisicaoRepository.findById(propriedadeRequest.getIdRequisicao());
        Requisicao requisicaoExistent = Optionalpropriedade.get();

      return propriedadeRepository.save(Propriedade.builder()
                .chave(propriedadeRequest.getChave())
                .valor(propriedadeRequest.getValor())
                .ordem(propriedadeRequest.getOrdem())
                .requisicao(requisicaoExistent)
                .build());
    }

    @Transactional
    @Override
    public void deletePropriedadeById(Long idPropriedade) {
        propriedadeRepository.deleteByIdPropriedade(idPropriedade);
    }


}
