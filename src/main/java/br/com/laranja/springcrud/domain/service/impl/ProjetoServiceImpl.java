package br.com.laranja.springcrud.domain.service.impl;

import br.com.laranja.springcrud.domain.dto.projeto.ProjetoRequest;
import br.com.laranja.springcrud.domain.model.Projeto;
import br.com.laranja.springcrud.domain.service.ProjetoService;
import br.com.laranja.springcrud.infrastructure.exception.ProjetoNameNotFoundException;
import br.com.laranja.springcrud.infrastructure.exception.ProjetoNotFoundException;
import br.com.laranja.springcrud.infrastructure.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjetoServiceImpl implements ProjetoService {
    private  final ProjetoRepository projetoRepository;


    @Override
    @Cacheable(value = "projetos")
    public Page<Projeto> getAllProjetos(Pageable paginacao) {
        return projetoRepository.findAll(paginacao);
    }

    @Override
    @CacheEvict(value = "projetos", allEntries = true)
    public Projeto getProjetoById(Long idProjeto) {
        return projetoRepository.findById(idProjeto).orElseThrow( () -> new ProjetoNotFoundException(idProjeto));
    }

    @Override
    @CacheEvict(value = "projetos", allEntries = true)
    public Projeto getProjetoByNome(String nome) {
        return projetoRepository.findByNome(nome).orElseThrow( () -> new ProjetoNameNotFoundException(nome));
    }


    @Override
    @CacheEvict(value = "projetos", allEntries = true)
    public Projeto createProjeto(ProjetoRequest projetoRequest) {
        Projeto projeto = Projeto.builder()
                .nome(projetoRequest.getNome())
                .situacao(projetoRequest.isSituacao())
                .build();
        return projetoRepository.save(projeto);
    }

    @Override
    @CacheEvict(value = "projetos", allEntries = true)
    public Projeto updateProjetoById(Long idProjeto, ProjetoRequest projetoRequest) {
        Optional<Projeto> projetoOptional = projetoRepository.findById(idProjeto);
        //verifica se tem o id no banco
        if(!projetoOptional.isPresent()){
            throw  new ProjetoNotFoundException(idProjeto);
        }
        Projeto projetoExistent = projetoOptional.get();
        return  projetoRepository.save(Projeto.builder()
                .idProjeto(projetoExistent.getIdProjeto()) // vai verificar se o id ja existe
                .nome(projetoRequest.getNome())
                .situacao(projetoRequest.isSituacao())
                .build());

    }

    @Transactional
    @Override
    @CacheEvict(value = "projetos", allEntries = true)
    public void deleteProjetoById(Long idProjeto) {
        Optional<Projeto> projeto = Optional.ofNullable(this.getProjetoById(idProjeto));
        if (!projeto.isPresent()) {
            throw new ProjetoNotFoundException(idProjeto);
        }
        projetoRepository.deleteByIdProjeto(idProjeto);
    }
}
