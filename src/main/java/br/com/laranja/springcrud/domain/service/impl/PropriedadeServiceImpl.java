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
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(value = "propriedade")
    public List<Propriedade> getAllPropriedades() {
        return propriedadeRepository.findAll();
    }

    @Override
    @CacheEvict(value = "propriedade", allEntries = true)
    public Propriedade getPropriedadeById(Long idPropriedade) {
        return propriedadeRepository.findById(idPropriedade).orElseThrow( () -> new PropriedadeNotFoundException(idPropriedade));
    }

    @Override
    @CacheEvict(value = "propriedade", allEntries = true)
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
    @CacheEvict(value = "propriedade", allEntries = true)
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
    @CacheEvict(value = "propriedade", allEntries = true)
    public void deletePropriedadeById(Long idPropriedade) {
        Optional<Propriedade> propriedade = Optional.ofNullable(this.getPropriedadeById(idPropriedade));
        if (!propriedade.isPresent()) {
            throw new PropriedadeNotFoundException(idPropriedade);
        }
        propriedadeRepository.deleteByIdPropriedade(idPropriedade);
    }


}
