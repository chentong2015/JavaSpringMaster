package com.spring.data.jpa.repositories;

import com.spring.data.jpa.entity.DemoEntity;
import org.springframework.data.repository.CrudRepository;

public interface DemoEntityRepository extends CrudRepository<DemoEntity, Integer> {
}
