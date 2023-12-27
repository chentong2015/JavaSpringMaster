package com.spring.tester1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TestHandlerException extends RuntimeException {

    public TestHandlerException(String message) {
        super(message);
    }
}
