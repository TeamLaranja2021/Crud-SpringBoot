package br.com.laranja.springcrud.infrastructure.exception;

public class TelaNotFoundException extends RuntimeException{
    private  Long idTela;

    public TelaNotFoundException(Long idTela) {
        super(String.format("Tela com id %s não foi encontrada", idTela));
        this.idTela = idTela ;
    }
}

