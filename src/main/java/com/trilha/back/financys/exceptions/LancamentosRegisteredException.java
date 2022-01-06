package com.trilha.back.financys.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LancamentosRegisteredException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public LancamentosRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public LancamentosRegisteredException(String message) {
        super(message);
    }
}