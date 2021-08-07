package br.com.laranja.springcrud.infrastructure.exception;

public class TelaNotFoundException extends RuntimeException{
    private  Long idTela;

    public TelaNotFoundException(Long idTela) {
        super(String.format("Id da Tela nao %s encontrado", idTela));
        this.idTela = idTela ;
    }
}

