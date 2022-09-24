package com.spring.data.jpa.controller;

import com.spring.data.jpa.entity.LargeObjectEntity;
import com.spring.data.jpa.repositories.LargeObjectEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LargeObjectEntityController {

    private LargeObjectEntityRepository repository;

    @Autowired
    public LargeObjectEntityController(LargeObjectEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @GetMapping("/get")
    @ResponseBody
    public String getSettings() {
        List<LargeObjectEntity> entityList = repository.findSettingsByName("name 1");
        StringBuilder builder = new StringBuilder();
        for (LargeObjectEntity entity : entityList) {
            builder.append(entity.getName());
        }
        return builder.toString();
    }
}
