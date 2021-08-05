package br.com.laranja.springcrud.apllication.controller;

import br.com.laranja.springcrud.domain.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProjetoController {
    private final ProjetoService projetoService;
}
