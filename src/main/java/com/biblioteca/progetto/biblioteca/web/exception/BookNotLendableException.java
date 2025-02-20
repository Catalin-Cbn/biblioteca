package com.biblioteca.progetto.biblioteca.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookNotLendableException extends RuntimeException {
    public BookNotLendableException(String message) {
        super(message);
    }
}
