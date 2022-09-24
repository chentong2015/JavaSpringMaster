package com.spring.data.jpa.controller;

import com.spring.data.jpa.entity.SettingsEntity;
import com.spring.data.jpa.repo.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SettingsController {

    private SettingsRepository repository;

    @Autowired
    public SettingsController(SettingsRepository repository) {
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
        List<SettingsEntity> entityList = repository.findSettingsByName("name 1");
        StringBuilder builder = new StringBuilder();
        for (SettingsEntity entity : entityList) {
            builder.append(entity.getName());
        }
        return builder.toString();
    }
}
