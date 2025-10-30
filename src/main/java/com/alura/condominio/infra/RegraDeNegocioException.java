package com.alura.condominio.infra;

public class RegraDeNegocioException extends RuntimeException{

    public RegraDeNegocioException(String mensage) {
        super(mensage);
    }

}
