package br.com.laranja.springcrud.infrastructure.exception;

public class EventoNotFoundException extends RuntimeException{
    private  Long idEvento;

    public EventoNotFoundException(Long idEvento) {
        super(String.format("Evento com id %s não foi encontrado", idEvento));
        this.idEvento = idEvento ;
    }
}

