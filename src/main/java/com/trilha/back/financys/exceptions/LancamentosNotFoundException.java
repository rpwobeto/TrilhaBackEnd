package com.trilha.back.financys.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LancamentosNotFoundException extends RuntimeException {

    public LancamentosNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public LancamentosNotFoundException(String message) {
        super(message);
    }
}

