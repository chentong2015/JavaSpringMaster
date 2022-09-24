package com.spring.tester2.controller;

import com.spring.tester2.exception.InternalServerException;
import com.spring.tester2.exception.ProductExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 全局处理异常的ControllerAdvice类，定义任何处理异常的处理方法
@ControllerAdvice
public class ProductExceptionControllerAdvice {

    // TODO. 异常处理的时候，抛出自定义的ResponseEntity<Object>
    @ExceptionHandler(value = ProductExistException.class)
    public ResponseEntity<String> handleProductExistException(ProductExistException exception) {
        System.out.println("Handle product exist exception !!");
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InternalServerException.class)
    public ResponseEntity<Object> handleInternalServerException(InternalServerException exception) {
        System.out.println("Handle internal Server exception !!");
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
