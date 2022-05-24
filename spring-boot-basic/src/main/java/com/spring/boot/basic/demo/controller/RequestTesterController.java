package com.spring.boot.basic.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// TODO. Spring对请求异常的默认解析，对应到指定的Http Status Code上面 > DefaultHandlerExceptionResolver
// 发送请求可能造成的异常：
// PUT http://localhost:8080/v2/api/data    > 404: "Not Found Exception"
// PUT http://localhost:8080/v1/api/data    > 405: "Method Not Allowed Exception"
// PUT http://localhost:8080/v1/api/data/xx > 400: "Bad Request Exception"
// 详细的异常信息可以返回给客户端

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
    public ResponseEntity<String> notfound() {
        return new ResponseEntity<>("INTERNAL SERVER ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
