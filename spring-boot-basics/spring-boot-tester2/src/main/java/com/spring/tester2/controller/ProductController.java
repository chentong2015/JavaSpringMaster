package com.spring.tester2.controller;

import com.spring.tester2.exception.InternalServerException;
import com.spring.tester2.exception.ProductExistException;
import com.spring.tester2.exception.TestHandlerException;
import com.spring.tester2.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController {

    private static Map<String, Product> mockProducts = new HashMap<>();

    static {
        Product product = new Product();
        product.setId("1");
        product.setName("apple");
        mockProducts.put("1", product);
    }

    @PostMapping("/products/{id}")
    public ResponseEntity<String> insertProduct(@PathVariable("id") String id, @RequestBody Product product) {
        // 首先在JPA层面需要做一个判断
        if (mockProducts.containsKey(id)) {
            throw new ProductExistException("Product already exists");
        }
        // Mock模拟在Server端持久层可能抛出的内部错误，触发指定的异常处理方法
        try {
            mockProducts.put(id, product);
        } catch (Exception exception) {
            throw new InternalServerException("Find Internal Exception Error");
        }
        // 按照正确的方式返回的数据，不会进入异常的处理方法中
        return new ResponseEntity<>("Product insert successfully", HttpStatus.OK);
    }

    // TODO. 测试如果ResponseEntity本身不带任何的message返回信息
    //       如何异常处理，并将抛出的异常"同步"报告给调用它的其他service
    @PostMapping("/products/test/{id}")
    public ResponseEntity<Void> testInsertProduct(@PathVariable("id") String id, @RequestBody Product product) {
        if (mockProducts.containsKey(id)) {
            throw new ProductExistException("Product already exists");
        }
        mockProducts.put(id, product);
        // 返回不带responseBody message的空ResponseEntity
        return ResponseEntity.ok().build();
    }

    @PostMapping("/products/exception/{id}")
    public ResponseEntity<String> testInsertProductException(@PathVariable("id") String id, @RequestBody Product product) {
        return new ResponseEntity<>("Test products exception", HttpStatus.BAD_REQUEST);
    }

    // TODO. 在没有@ExceptionHandler的情况下，这里如果直接抛出异常，将显示如下的错误
    // 当前端显示的错误信息
    // {
    //    "timestamp": "2022-05-25T16:25:34.631+00:00",
    //    "status": 500,
    //    "error": "Internal Server Error",
    //    "path": "/products/post/3"
    // }
    // 调用的client端同样显示错误信息 ==> 并不能获取到error exception的内容 !!
    // {  "timestamp":"2022-05-25T16:26:42.087+00:00",
    //    "status":500,
    //    "error":"Internal Server Error",
    //    "path":"/products/post/6"
    // }
    // @ExceptionHandler(ProductExistException.class)
    @PostMapping("/products/post/{id}")
    public ResponseEntity<String> testPostProduct(@PathVariable("id") String id, @RequestBody Product product) {
        // return new ResponseEntity<>("bad request testing", HttpStatus.BAD_REQUEST);
        throw new ProductExistException("Exception: Product already exists");
    }

    // TODO. @ExceptionHandler 异常处理器中定义的是要处理的异常类型(被标记的方法抛出的异常类型)
    @ExceptionHandler(TestHandlerException.class)
    @PostMapping("/products/handler/{id}")
    public ResponseEntity<Void> testPostProductWithHandler(@PathVariable("id") String id, @RequestBody Product product) {
        throw new TestHandlerException("Exception: Product already exists");
    }
}
