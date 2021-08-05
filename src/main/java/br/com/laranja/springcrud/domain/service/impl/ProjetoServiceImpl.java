package br.com.laranja.springcrud.domain.service.impl;

import br.com.laranja.springcrud.domain.service.ProjetoService;
import br.com.laranja.springcrud.infrastructure.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjetoServiceImpl implements ProjetoService {
    private  final ProjetoRepository projetoRepository;
}
