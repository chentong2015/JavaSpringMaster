package com.example.aop.service;

import com.example.aop.entity.Race;
import com.example.aop.exception.MyApplicationException;
import com.example.aop.repository.RaceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;

@SpringBootTest
class RaceServiceTest {

    @Autowired
    private RaceService raceService;

    @MockBean
    private RaceRepository raceRepository;

    @Test
    void test_save_race() throws MyApplicationException {
        Race race = new Race(1L, "Match 02", new Date(), new ArrayList<>());
        Mockito.when(raceRepository.getRaceByNumber(1L)).thenReturn(null);
        Mockito.when(raceRepository.save(race)).thenReturn(race);
        Assertions.assertTrue(raceService.saveRace(race));
    }
}
