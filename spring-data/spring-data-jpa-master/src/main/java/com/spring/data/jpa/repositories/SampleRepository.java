package com.spring.data.jpa.repositories;

import com.spring.data.jpa.entity.SampleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository extends CrudRepository<SampleEntity, Long> {

    // Native Query查询时字段间不一定要设置间隔
    @Query(value = "select id,name from t_samples order by id desc", nativeQuery = true)
    List<Object[]> loadAllStates();
}
