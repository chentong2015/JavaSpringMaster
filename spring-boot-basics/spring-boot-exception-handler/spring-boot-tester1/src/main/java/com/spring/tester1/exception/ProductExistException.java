package com.spring.tester1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProductExistException extends RuntimeException {

    public ProductExistException(String message) {
        super(message);
    }
}
