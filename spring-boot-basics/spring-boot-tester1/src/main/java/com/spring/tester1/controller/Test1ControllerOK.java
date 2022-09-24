package com.spring.tester1.controller;

import com.spring.tester1.exception.TestHandlerException;
import com.spring.tester1.model.Product;
import com.spring.tester1.service.ProductService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@RestController
public class Test1ControllerOK {

    private final ProductService productService;

    @Autowired
    public Test1ControllerOK(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products/handler/{id}")
    public ResponseEntity<String> insertProduct(@PathVariable("id") String id, @RequestBody Product product) {
        try {
            // 只要这里的请求表示200正常返回，则会进入异常捕获条件 !!
            productService.testPostProductHandler(id, product);
            System.out.println("test post handler ok");
            return ResponseEntity.ok().build();

        } catch (TestHandlerException handlerException) {
            // 根据捕获到的异常，能够mapping到指定的Response httpCode
            // 无法准确获取后端的异常信息message !!
            // {"timestamp":"2022-05-27T14:09:09.267+00:00","status":400,"error":"Bad Request","path":"/products/handler/3"}
            System.out.println(handlerException.getMessage());
            return new ResponseEntity<>(handlerException.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (FeignException exception) {
            // logger.error("Error: message", exception); 需要提供日志错误的输出
            // System.out.printf(exception.getMessage()); 获取整个的exception的内容信息
            Optional<ByteBuffer> response = exception.responseBody();
            HttpStatus httpStatus = HttpStatus.valueOf(exception.status());
            if (response.isPresent()) {
                String error = StandardCharsets.UTF_8.decode(response.get()).toString();
                return new ResponseEntity<>(error, httpStatus);
            }
            return new ResponseEntity<>("error", httpStatus);
        }
    }
}
