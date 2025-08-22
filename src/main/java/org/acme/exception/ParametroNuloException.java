package org.acme.exception;

public class ParametroNuloException extends RuntimeException{
    public ParametroNuloException(String message){
        super(message);
    }
}