package spring.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import spring.exception.NotFoundException;

// 用来全局地处理Controller抛出的异常
@ControllerAdvice
public class HomeControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public void handleNotFoundException(NotFoundException exception) {
        System.out.println("handle exception");
        System.out.println(exception.getMessage());
    }
}
