package com.example.main.controller;

import com.example.main.entity.RoutingRuleDao;
import com.example.main.repository.RoutingRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class RoutingRuleController {

    private RoutingRuleRepository repository;

    @Autowired
    public RoutingRuleController(RoutingRuleRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/rule")
    @ResponseBody
    public String getRule() {
        Optional<RoutingRuleDao> result = repository.findByRuleElementsIsEmpty();
        System.out.println(result.isEmpty());
        return "check ok";

    }
}
