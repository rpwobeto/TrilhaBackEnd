package com.trilha.back.financys.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerRestApi {

    @ExceptionHandler(DivisaoZeroException.class)
    public ResponseEntity<?> divisaoPorZero(DivisaoZeroException exception){

        BuilderExceptions exceptions = new BuilderExceptions(exception.getMessage());
        return new ResponseEntity<>(exceptions, HttpStatus.NOT_ACCEPTABLE);

    }


}