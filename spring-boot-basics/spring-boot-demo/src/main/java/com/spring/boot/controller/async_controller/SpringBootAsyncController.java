package com.spring.boot.controller.async_controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SpringBootAsyncController {

    @GetMapping(value = "ping/async")
    public ResponseEntity<Map<String, String>> async() {
        // TODO: 必须在@service的方法上标注 @Async("asyncTaskExecutor")
        // 将耗时的操作并发的执行，然后Endpoint立即返回response到client端
        // processService.process();
        Map<String, String> response = new HashMap<>();
        response.put("message", "Request is under process");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
