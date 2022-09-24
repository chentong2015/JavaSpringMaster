package com.spring.data.jpa.repositories;

import com.spring.data.jpa.entity.LargeObjectEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LargeObjectEntityRepository extends CrudRepository<LargeObjectEntity, Integer> {

    // @Transactional
    List<LargeObjectEntity> findSettingsByName(String name);
}
