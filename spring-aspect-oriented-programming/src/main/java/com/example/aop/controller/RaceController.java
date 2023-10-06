package com.example.aop.controller;

import com.example.aop.entity.Race;
import com.example.aop.exception.MyApplicationException;
import com.example.aop.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RaceController {

    private final RaceService raceService;

    @Autowired
    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/race/create")
    public String createRace(@RequestBody Race race) {
        try {
            boolean result = this.raceService.saveRace(race);
            return result ? "Create race OK" : "Failed: check if the number is exist";
        } catch (MyApplicationException exception) {
            return "Failed with exception: " + exception.getMessage();
        }
    }
}
