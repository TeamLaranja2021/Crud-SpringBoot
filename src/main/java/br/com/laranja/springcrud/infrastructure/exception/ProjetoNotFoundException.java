package br.com.laranja.springcrud.infrastructure.exception;

public class ProjetoNotFoundException extends  RuntimeException{
    private  Long idProjeto;

    public ProjetoNotFoundException(Long idProjeto) {
        super(String.format("Projeto com id %s não foi encontrado", idProjeto));
        this.idProjeto = idProjeto ;
    }

}
