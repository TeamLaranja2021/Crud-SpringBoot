package br.com.laranja.springcrud.infrastructure.exception;

import lombok.Getter;

@Getter
public class EntityWithDependentsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String entidade;
    private String vinculo;

    public EntityWithDependentsException(String entidade, String vinculo, String message) {
        super(String.format("%s não pode ser excluido(a) pois já possui %s vinculado(a).", entidade, vinculo));
        this.entidade = entidade;
        this.vinculo = vinculo;
    }
}