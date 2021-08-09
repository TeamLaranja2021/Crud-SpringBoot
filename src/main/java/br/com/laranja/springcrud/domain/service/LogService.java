/*package br.com.laranja.springcrud.domain.service;

import br.com.laranja.springcrud.infrastructure.repository.LogRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@Service
@RestControllerAdvice
public interface LogService {
    private final LogRepository logginRepository;

    public default void log(Exception e){
        Loger log = Loger.builder()
                .messagem(e.getMessage())
                .data(LocalDateTime.now())
                .build();

        logRepository.save(log);
    }

}*/
