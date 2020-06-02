package com.api.raccoltoemoraes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ExceptionDataInvalida extends RuntimeException {

    public ExceptionDataInvalida(String message) {
        super(message);
    }
}
