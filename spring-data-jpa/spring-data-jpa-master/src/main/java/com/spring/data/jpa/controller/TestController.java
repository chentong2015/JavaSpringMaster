package com.spring.data.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    // TODO. Jackson会将返回的对象自动转成Json格式
    @GetMapping("/test")
    public Map testContentMap() {
        Map<String, String> map = new HashMap<>();
        for (int index = 1; index < 10000; index++) {
            map.put("app-version" + index, "this is a test " + index);
        }
        return map;
    }
}
