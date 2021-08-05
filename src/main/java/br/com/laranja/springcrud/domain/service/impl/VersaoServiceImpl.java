package br.com.laranja.springcrud.domain.service.impl;


import br.com.laranja.springcrud.domain.service.VersaoService;
import br.com.laranja.springcrud.infrastructure.repository.VersaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VersaoServiceImpl implements VersaoService {
    private  final VersaoRepository versaoRepository;

}
