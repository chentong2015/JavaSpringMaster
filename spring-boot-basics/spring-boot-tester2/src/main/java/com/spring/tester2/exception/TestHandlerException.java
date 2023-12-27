package com.spring.tester2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 做一个异常捕获之后的对应关系
// 如果controller method抛出异常，则出现以下错误
// {
//    "timestamp": "2022-05-27T14:08:45.086+00:00",
//    "status": 400,
//    "error": "Bad Request", 这里的异常信息没有办法显示 !!
//    "path": "/products/handler/3"
// }
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TestHandlerException extends RuntimeException {

    public TestHandlerException(String message) {
        super(message);
    }
}
