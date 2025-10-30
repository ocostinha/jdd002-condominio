package com.alura.condominio.infra;

public class RecursoNaoEncontradoException extends RuntimeException{

    public RecursoNaoEncontradoException(String mensage) {
        super(mensage);
    }

}
