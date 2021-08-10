package br.com.laranja.springcrud.infrastructure.exception;

public class RequisicaoNotFoundException extends RuntimeException{
    private  Long idRequisicao;

    public RequisicaoNotFoundException(Long idRequisicao) {
        super(String.format("Requisição com id %s não foi encontrada", idRequisicao));
        this.idRequisicao = idRequisicao ;
    }
}
