package com.spring.tester2.exception;

public class ProductExistException extends RuntimeException {

    public ProductExistException(String message) {
        super(message);
    }
}
