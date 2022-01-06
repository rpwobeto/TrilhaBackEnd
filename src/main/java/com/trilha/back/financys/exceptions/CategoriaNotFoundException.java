package com.trilha.back.financys.exceptions;

public class CategoriaNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CategoriaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoriaNotFoundException(String message) {
        super(message);
    }

}

