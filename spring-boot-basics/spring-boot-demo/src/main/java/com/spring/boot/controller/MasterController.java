package com.spring.boot.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MasterController {

    @GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public void get() {
        // 设置请求返回数据的MediaType类型
    }

    @PostMapping(value = "/data", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void post() {
        // 处理(消费)提供的JSON格式的数据
    }

    @GetMapping("/v1/info/get")
    public List<String> getInformation() {
        return null;
        // return new ArrayList<>();
    }
}
