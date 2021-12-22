package com.trilha.back.financys.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidOperation  extends RuntimeException {

    public InvalidOperation(String message){
        super(message);
    }
}