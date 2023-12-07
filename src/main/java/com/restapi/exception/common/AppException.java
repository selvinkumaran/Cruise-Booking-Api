package com.restapi.exception.common;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {

    private final String message;

    public AppException(HttpStatus status, String message) {
        this.message = message;
    }

    public AppException(String message, HttpStatus status, String message1) {
        super(message);
        this.message = message1;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
