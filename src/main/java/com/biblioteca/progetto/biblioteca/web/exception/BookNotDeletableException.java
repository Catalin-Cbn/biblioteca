package com.biblioteca.progetto.biblioteca.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class BookNotDeletableException extends RuntimeException {
    public BookNotDeletableException(String message) {
        super(message);
    }
}
