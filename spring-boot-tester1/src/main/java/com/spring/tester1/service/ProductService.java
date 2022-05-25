package com.spring.tester1.service;

import com.spring.tester1.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// 指定要发送的Server端的URL
@FeignClient(value = "product-service", url = "http://localhost:8082/")
public interface ProductService {

    // 这里和要发送请求的Service Controller的方法一致
    @PostMapping(value = "/products/{id}", consumes = "application/json;charset=UTF-8")
    ResponseEntity<String> insertProduct(@PathVariable("id") String id, @RequestBody Product product);

    // 没有response body的返回信息
    // TODO. 但这里的方法可能抛出FeignException异常，被调用它的方法所捕获
    //       异常携带的是请求的server上的(非200)对于的错误信息 !!
    @PostMapping(value = "/products/test/{id}", consumes = "application/json;charset=UTF-8")
    ResponseEntity<String> testInsertProduct(@PathVariable("id") String id, @RequestBody Product product);
}
