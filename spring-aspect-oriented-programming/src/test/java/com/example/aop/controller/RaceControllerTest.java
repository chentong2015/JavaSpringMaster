package com.example.aop.controller;

import com.example.aop.entity.Race;
import com.example.aop.service.RaceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 这里的测试可以指定要启动的Spring Application Context
// 可以指定启动特定的Test Context
@SpringBootTest // (classes = PmuExerciseApplication.class)
@AutoConfigureMockMvc
class RaceControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private RaceService raceService;

    @Test
    void test_create_race() throws Exception {
        Race race = new Race(2L, "Match 02", new Date(), new ArrayList<>());
        if (raceService.hasFoundRace(race)) {
            raceService.deleteRaceByNumber(race.getNumber());
        }
        mvc.perform(MockMvcRequestBuilders.post("/race/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(race)))
                .andExpect(status().isOk())
                .andExpect(content().string("Create race OK"));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
