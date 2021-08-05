package br.com.laranja.springcrud.domain.service.impl;

import br.com.laranja.springcrud.domain.dto.ProjetoRequest;
import br.com.laranja.springcrud.domain.model.Projeto;
import br.com.laranja.springcrud.domain.model.Usuario;
import br.com.laranja.springcrud.domain.model.Versao;
import br.com.laranja.springcrud.domain.service.ProjetoService;
import br.com.laranja.springcrud.infrastructure.exception.ProjetoNotFoundException;
import br.com.laranja.springcrud.infrastructure.exception.UsuarioNotFoundException;
import br.com.laranja.springcrud.infrastructure.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjetoServiceImpl implements ProjetoService {
    private  final ProjetoRepository projetoRepository;

    @Override
    public List<Projeto> getAllProjetos() {
        return projetoRepository.findAll();
    }

    @Override
    public Projeto getProjetoById(Long idProjeto) {
        return projetoRepository.findById(idProjeto).orElseThrow( () -> new ProjetoNotFoundException(idProjeto));
    }

    @Override
    public Projeto createProjeto(ProjetoRequest projetoRequest) {
        Projeto projeto = Projeto.builder()
                .nome(projetoRequest.getNome())
                .situacao(projetoRequest.isSituacao())
                .versoes(projetoRequest.getVersoes())
                .build();
        return projetoRepository.save(projeto);
    }

    @Override
    public Projeto updateProjetoById(Long idProjeto, ProjetoRequest projetoRequest) {
        Optional<Projeto> projetoOptional = projetoRepository.findById(idProjeto);

        //verifica se tem o id no banco
        if(!projetoOptional.isPresent()){
            throw  new ProjetoNotFoundException(idProjeto);
        }

       /* Optional<Versao> versaoOptional =  versaoRepository.findById(versaoRepository.get());
        if (!versaoOptional.isPresent()) {
            throw new versaoNotFoundException(versaoRequest.getVersaoId().toString());
        }
        Versao sectorExistent = versaoOptional.get();*/

        Projeto projetoExistent = projetoOptional.get();
        return  projetoRepository.save(Projeto.builder()
                .idProjeto(projetoExistent.getIdProjeto()) // vai verificar se o id ja existe
                .nome(projetoRequest.getNome())
                .situacao(projetoRequest.isSituacao())
                .versoes(projetoRequest.getVersoes())
                .build());

    }

    @Transactional
    @Override
    public void deleteProjeotById(Long idProjeto) {
        projetoRepository.deleteByIdProjeto(idProjeto);
    }
}
