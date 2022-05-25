package com.spring.tester1.controller;

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
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

// 项目场景 ::
// SpringBootA的endpoints对等调用SpringBootB的endpoints
// 在SpringBootB上抛出的Exception异常错误信息，需要"同步"体现在SpringBootA上
@RestController
public class Test1Controller {

    private final ProductService productService;

    // TODO. 自动注入，注入Spring Feign Client bean
    @Autowired
    public Test1Controller(ProductService productService) {
        this.productService = productService;
    }

    // TODO. 使用Spring Cloud Feign发送请求，报出的错误是FeignException
    //       通过捕获可以获得和server端一致的报错信息 + StatusCode
    @PostMapping("/products/{id}")
    public ResponseEntity<String> insertProduct(@PathVariable("id") String id, @RequestBody Product product) {
        try {
            return productService.insertProduct(id, product);

            // 如果上面的feign client请求抛出异常，则下面的逻辑无法被执行到
            // if (response.getStatusCode().isError()) {
            //     System.out.println(response.getStatusCodeValue());
            //     System.out.printf(response.getBody());
            // } else {
            //     System.out.printf("200 OK");
            // }
            // return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (FeignException exception) {
            // logger 需要提供日志错误的输出
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

    @PostMapping("/products/test/{id}")
    public ResponseEntity<String> testInsertProduct(@PathVariable("id") String id, @RequestBody Product product) {
        try {
            productService.testInsertProduct(id, product);
            // return new ResponseEntity<>("success", HttpStatus.OK);
            URI uri = UriComponentsBuilder
                    .fromPath("/v1/statics/data/{id}")
                    .buildAndExpand("e17dd1f1")
                    .toUri();
            return ResponseEntity.created(uri).body("success");

        } catch (FeignException exception) {
            // logger.error("Error: message", exception); 需要提供日志错误的输出
            // System.out.printf(exception.getMessage()); 获取整个的exception的内容信息

            Optional<ByteBuffer> response = exception.responseBody();
            HttpStatus httpStatus = HttpStatus.valueOf(exception.status());
            if (response.isPresent()) {
                String error = StandardCharsets.UTF_8.decode(response.get()).toString();
                System.out.println("error ---- " + error);
                return new ResponseEntity<>(error, httpStatus);
            }
            // TODO. 捕获异常后，在tester1层的controller没有抛出异常
            //       直接拿到的是对应的错误信息和httpStatus
            return new ResponseEntity<>("error ...", httpStatus);
        }
    }
}
