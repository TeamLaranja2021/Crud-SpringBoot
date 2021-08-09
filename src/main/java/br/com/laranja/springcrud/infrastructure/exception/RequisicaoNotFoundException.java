package br.com.laranja.springcrud.infrastructure.exception;

public class RequisicaoNotFoundException extends RuntimeException{
    private  Long idRequisicao;

    public RequisicaoNotFoundException(Long idRequisicao) {
        super(String.format("Id do Requisicao %s encontrado", idRequisicao));
        this.idRequisicao = idRequisicao ;
    }
}
