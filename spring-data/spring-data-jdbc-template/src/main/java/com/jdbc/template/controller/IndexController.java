package com.jdbc.template.controller;

import com.jdbc.template.model.Information;
import com.jdbc.template.template.SpringJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private SpringJdbcTemplate jdbcTemplate;

    @Autowired
    public IndexController(SpringJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/index")
    @ResponseBody
    public String indexJdbcTemplate() {
        Information information = new Information(3, "name2", "place2", 2024);
        jdbcTemplate.insertInformation(information);

        return jdbcTemplate.getInformation(1).getName();
    }
}