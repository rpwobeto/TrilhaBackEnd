package com.trilha.back.financys.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class CategoriaFoundException extends RuntimeException {

        public CategoriaFoundException(String message) {
            super(message);
        }
    }

