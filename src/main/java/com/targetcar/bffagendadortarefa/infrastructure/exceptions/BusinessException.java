package com.targetcar.bffagendadortarefa.infrastructure.exceptions;

public class BusinesException extends RuntimeException {

    public BusinesException(String mensagem){
        super(mensagem);
    }

    public BusinesException(String mensagem, Throwable throwable){
        super(mensagem, throwable);
    }
}
