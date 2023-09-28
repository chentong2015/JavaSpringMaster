package com.spring.data.jpa.service;

import com.spring.data.jpa.entity.SampleEntity;
import com.spring.data.jpa.repositories.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {

    private SampleRepository sampleRepository;

    @Autowired
    public SampleService(SampleRepository repository) {
        this.sampleRepository = repository;
    }

    public void saveSample() {
        SampleEntity entity = new SampleEntity("user@test.com", "test");
        sampleRepository.save(entity);
    }

    public List<Object[]> getAllSample() {
        return sampleRepository.loadAllStates();
    }
}
