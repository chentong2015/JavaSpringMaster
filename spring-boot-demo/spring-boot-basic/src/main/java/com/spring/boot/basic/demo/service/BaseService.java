package com.spring.boot.basic.demo.service;

import com.spring.boot.basic.demo.thymeleaf.ISpringInternationalization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {

    private final ISpringInternationalization springInternationalization;

    @Autowired
    public BaseService(ISpringInternationalization springInternationalization) {
        this.springInternationalization = springInternationalization;
    }

    public String getGameMessage() {
        return springInternationalization.getGameMessage();
    }
}
