package com.example.aop.repository;

import com.example.aop.entity.Race;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends CrudRepository<Race, Long> {

    Race getRaceByNumber(Long number);

}
