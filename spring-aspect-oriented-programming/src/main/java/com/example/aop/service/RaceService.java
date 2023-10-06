package com.example.aop.service;

import com.example.aop.entity.Race;
import com.example.aop.exception.MyApplicationException;
import com.example.aop.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RaceService {

    private final RaceRepository raceRepository;

    @Autowired
    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    // Make sure it doesn't exist the same number before saving race in DB
    public boolean saveRace(Race race) throws MyApplicationException {
        try {
            if (hasFoundRace(race)) {
                return false;
            }
            Race savedRace = this.raceRepository.save(race);
            return Objects.equals(savedRace.getNumber(), race.getNumber());
        } catch (Exception exception) {
            throw new MyApplicationException("Save race entity failed!");
        }
    }

    public boolean hasFoundRace(Race race) {
        Race oldRace = this.raceRepository.getRaceByNumber(race.getNumber());
        return oldRace != null;
    }

    public void deleteRaceByNumber(long number) throws MyApplicationException {
        try {
            this.raceRepository.deleteById(number);
        } catch (Exception exception) {
            throw new MyApplicationException("Save race failed !" + number);
        }
    }
}
