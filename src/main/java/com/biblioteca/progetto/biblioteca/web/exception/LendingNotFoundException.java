package com.biblioteca.progetto.biblioteca.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LendingNotFoundException extends RuntimeException{

    public LendingNotFoundException(String message) {
        super(message);
    }
}
