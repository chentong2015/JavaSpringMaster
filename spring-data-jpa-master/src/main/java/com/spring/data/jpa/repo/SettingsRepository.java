package com.spring.data.jpa.repo;

import com.spring.data.jpa.entity.SettingsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SettingsRepository extends CrudRepository<SettingsEntity, Integer> {

    // @Transactional
    List<SettingsEntity> findSettingsByName(String name);
}
