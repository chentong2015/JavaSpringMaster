package com.spring.data.jpa.controller;

import com.spring.data.jpa.entity.DemoEntity;
import com.spring.data.jpa.repositories.DemoEntityRepository;
import com.spring.data.jpa.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BatchDemoController {

    private BatchService batchService;
    private DemoEntityRepository demoEntityRepository;

    @Autowired
    public BatchDemoController(DemoEntityRepository demoEntityRepository, BatchService batchService) {
        this.demoEntityRepository = demoEntityRepository;
        this.batchService = batchService;
    }

    @GetMapping("/demo/home")
    public String demoHome() {
        return "demo home";
    }

    @GetMapping("batch/{id}")
    public String getBatchLabel(@PathVariable Long id) {
        return batchService.findLabelById(id);
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
