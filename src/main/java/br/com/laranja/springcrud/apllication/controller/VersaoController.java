package br.com.laranja.springcrud.apllication.controller;


import br.com.laranja.springcrud.domain.service.VersaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VersaoController {
    private final VersaoService versaoService;
}
