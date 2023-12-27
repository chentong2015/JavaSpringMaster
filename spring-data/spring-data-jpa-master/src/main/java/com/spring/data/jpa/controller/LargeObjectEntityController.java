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

    @ResponseBody
    @GetMapping("/save")
    public String hello() {
        LargeObjectEntity entity = new LargeObjectEntity("name 1");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < 100000; i++) {
            stringBuilder.append("test test test test");
        }
        entity.setJsonData(stringBuilder.toString());
        repository.save(entity);
        return "Save ok.";
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
