package br.com.laranja.springcrud.infrastructure.exception;

public class PropriedadeNotFoundException extends  RuntimeException {
    private Long idPropriedade;

    public PropriedadeNotFoundException(Long idPropriedade) {
        super(String.format("Id da propriedade %s nao foi encontrado", idPropriedade));
        this.idPropriedade = idPropriedade;
    }
}
