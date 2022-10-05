package com.spring.data.jpa.controller;

import com.spring.data.jpa.entity.DemoEntity;
import com.spring.data.jpa.repositories.DemoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {

    private DemoEntityRepository demoEntityRepository;

    @Autowired
    public DemoController(DemoEntityRepository demoEntityRepository) {
        this.demoEntityRepository = demoEntityRepository;
    }

    // TODO. Jackson会将返回的对象自动转成Json格式
    @GetMapping("/test")
    public Map testContentMap() {
        Map<String, String> map = new HashMap<>();
        for (int index = 1; index < 10000; index++) {
            map.put("app-version" + index, "this is a test " + index);
        }
        return map;
    }

    @ResponseBody
    @GetMapping("/demo")
    public String testDemoEntity() {
        DemoEntity demoEntity = new DemoEntity("name 1");
        demoEntityRepository.save(demoEntity);
        return "count: " + demoEntityRepository.count();
    }
}
