package br.com.laranja.springcrud.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Loger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String messagem;
    private LocalDateTime data;
}

