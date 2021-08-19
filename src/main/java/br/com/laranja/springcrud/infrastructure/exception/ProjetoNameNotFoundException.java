package br.com.laranja.springcrud.infrastructure.exception;

public class ProjetoNameNotFoundException extends  RuntimeException{
    private  String nome;

    public ProjetoNameNotFoundException(String nome) {
        super(String.format("Projeto com o nome %s não foi encontrado", nome));
    this.nome = nome ;
    }
}
