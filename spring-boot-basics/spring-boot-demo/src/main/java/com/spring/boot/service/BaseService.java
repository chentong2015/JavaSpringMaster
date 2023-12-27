package com.spring.boot.service;

import com.spring.boot.thymeleaf.ISpringInternationalization;
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
