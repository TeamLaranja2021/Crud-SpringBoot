package br.com.laranja.springcrud.domain.service;

import br.com.laranja.springcrud.domain.model.Loger;
import br.com.laranja.springcrud.infrastructure.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;

    public void log(Exception e){
        Loger log = Loger.builder()
                .messagem(e.getMessage())
                .data(LocalDateTime.now())
                .build();

        logRepository.save(log);
    }

}
