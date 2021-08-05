package br.com.laranja.springcrud.infrastructure.exception;

public class VersaoNotFoundException extends  RuntimeException{
    private  Long idVersao;

    public VersaoNotFoundException(Long idVersao) {
        super(String.format("Id versao do projeto %s encrotrada", idVersao));
        this.idVersao = idVersao ;
    }
}
