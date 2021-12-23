package com.trilha.back.financys.exceptions;

public class DivisaoZeroException extends RuntimeException {
    private static final long serialVersionUid = 1L;

    public DivisaoZeroException(String message){

        super(message);
    }
}