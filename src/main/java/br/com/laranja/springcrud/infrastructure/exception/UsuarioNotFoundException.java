package br.com.laranja.springcrud.infrastructure.exception;

public class UsuarioNotFoundException  extends RuntimeException{
    private  Long idUsuario;

    public UsuarioNotFoundException(Long idUsuario) {
        super(String.format("Id do Usuario %s encontrado", idUsuario));
        this.idUsuario = idUsuario ;
    }
}
