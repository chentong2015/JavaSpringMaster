package com.spring.boot.basic.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

// TODO. Spring对请求异常的默认解析DefaultHandlerExceptionResolver，对应不同的Status Code
@RestController
@RequestMapping("/v1/api/")
public class RequestTesterController {

    @GetMapping("/data")
    public String getData() {
        return "data: ok";
    }

    @PostMapping("/data/post")
    public String post(@RequestParam Long id) {
        return "post: ok";
    }

    @DeleteMapping("/data/{id}")
    public String put(@PathVariable Long id) {
        return "delete: ok";
    }

    // TODO. PUT http://localhost:8080/v1/api/data/
    //  如果发送的请求没有带{id}, 则该PUT请求将找不到指定的方法来分发请求, 应该返回404的请求
    //  逻辑上不会被分发到 GET http://localhost:8080/v1/api/data/
    @PutMapping("/data/{id}")
    public String delete(@PathVariable Long id) {
        return "put: ok";
    }

    // TODO. 测试Server端正常处理，但是返回的entity-body中不包含任何的内容
    @GetMapping("/no-content")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void testNoContent() {
    }

    @GetMapping("/testing")
    public Object testingNoContent() {
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // TODO. 测试返回的结果中包含content, 使用ResponseEntity body
    @GetMapping("/error")
    public ResponseEntity<String> error() {
        return new ResponseEntity<>("INTERNAL SERVER ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // TODO. 对于不带body的ResponseEntity的build构建
    @GetMapping("/null-content")
    public ResponseEntity<Void> nullContent() {
        URI location = URI.create("uri");
        return ResponseEntity.created(location).build();
    }

    // TODO. 将请求后特定的URI信息设置到ResponseEntity的头部"header"中
    // .andExpect(header().string("Location", "/v1/statics/data/e17dd1f1");
    @PostMapping("/response-with-header")
    public ResponseEntity<Void> responseWithHeader() {
        URI uri = UriComponentsBuilder
                .fromPath("/v1/statics/data/{id}")
                .buildAndExpand("e17dd1f1")
                .toUri();
        return ResponseEntity.created(uri).build();

        // String id = "e17dd1f1-f72d-";
        // return ResponseEntity.created(UriComponentsBuilder
        //        .fromPath("/v1/examples/data/{id}")
        //        .buildAndExpand(id).toUri()).build();
    }

    // 设置头部信息的同时，提供response body的数据
    @PostMapping("/response-with-header-and-body")
    public ResponseEntity<String> responseWithHeaderAndBody() {
        URI uri = UriComponentsBuilder
                .fromPath("/v1/statics/data/{id}")
                .buildAndExpand("e17dd1f1")
                .toUri();
        return ResponseEntity.created(uri).body("body message");
    }
}
