package com.restapi.exception.common;

import lombok.Getter;

@Getter
public class InvalidUserException extends RuntimeException {

    public InvalidUserException(String message) {
        super(message);
    }
}
