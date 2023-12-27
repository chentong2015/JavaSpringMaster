package com.spring.data.jpa.controller;

import com.spring.data.jpa.service.MyConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationController {

    private MyConfigurationService myConfigurationService;

    public ConfigurationController(@Autowired MyConfigurationService myConfigurationService) {
        this.myConfigurationService = myConfigurationService;
    }
}
