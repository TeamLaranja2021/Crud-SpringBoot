package br.com.laranja.springcrud.infrastructure.exception;

public class VersaoNotFoundException extends  RuntimeException{
    private  Long idVersao;

    public VersaoNotFoundException(Long idVersao) {
        super(String.format("Versão com id %s não foi encontrado", idVersao));
        this.idVersao = idVersao ;
    }
}
