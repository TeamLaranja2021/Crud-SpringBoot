package br.com.laranja.springcrud.infrastructure.exception;

public class TipoEventoNotFoundException extends RuntimeException{
    private  Long idTipoEvento;

    public TipoEventoNotFoundException(Long idTipoEvento) {
        super(String.format("Tipo de evento com id %s não foi encontrado", idTipoEvento));
        this.idTipoEvento = idTipoEvento ;
    }
}

