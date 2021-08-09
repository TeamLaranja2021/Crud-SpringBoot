package br.com.laranja.springcrud.infrastructure.exception;

public class UsuarioNotFoundException  extends RuntimeException{
    private  Long idUsuario;

    public UsuarioNotFoundException(Long idUsuario) {
        super(String.format("usuário com id %s não foi encontrado", idUsuario));
        this.idUsuario = idUsuario ;
    }
}
