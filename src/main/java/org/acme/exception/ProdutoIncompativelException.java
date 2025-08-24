package org.acme.exception;

public class ProdutoIncompativelException extends RuntimeException {
    public ProdutoIncompativelException(String message) {
        super(message);
    }
}
