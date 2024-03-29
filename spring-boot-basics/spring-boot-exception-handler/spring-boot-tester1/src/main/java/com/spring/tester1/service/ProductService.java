package com.spring.tester1.service;

import com.spring.tester1.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// TODO. Failed to load ApplicationContext 在初始化构建的时候，这里的feign client必须要能够构建出来
// 指定要发送的Server端的URL, 注意测试和模拟这里的URL
@FeignClient(value = "product-service", url = "http://localhost:5679/")
public interface ProductService {

    // 这里和要发送请求的Service Controller的方法一致
    @PostMapping(value = "/products/{id}", consumes = "application/json;charset=UTF-8")
    ResponseEntity<String> insertProduct(@PathVariable("id") String id, @RequestBody Product product);

    // TODO. 但这里的方法可能抛出FeignException异常，被调用它的方法所捕获
    //       异常携带的是请求的server上的(非200)对于的错误信息 !!
    // 这里并需要设置ResponseEntity<String>, 在捕获到该方法的异常时也能拿到对应的String message !!
    @PostMapping(value = "/products/test/{id}", consumes = "application/json;charset=UTF-8")
    ResponseEntity<Void> testInsertProduct(@PathVariable("id") String id, @RequestBody Product product);

    @PostMapping(value = "/products/exception/{id}", consumes = "application/json;charset=UTF-8")
    ResponseEntity<Void> testInsertProductException(@PathVariable("id") String id, @RequestBody Product product);


    @PostMapping(value = "/products/post/{id}", consumes = "application/json;charset=UTF-8")
    ResponseEntity<String> testPostProduct(@PathVariable("id") String id, @RequestBody Product product);

    @PostMapping(value = "/products/handler/{id}", consumes = "application/json;charset=UTF-8")
    ResponseEntity<Void> testPostProductHandler(@PathVariable("id") String id, @RequestBody Product product);
}
