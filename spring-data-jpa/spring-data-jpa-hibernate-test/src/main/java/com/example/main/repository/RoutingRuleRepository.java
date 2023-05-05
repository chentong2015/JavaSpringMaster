package com.example.main.repository;

import com.example.main.entity.RoutingRuleDao;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoutingRuleRepository extends CrudRepository<RoutingRuleDao, Long> {

    Optional<RoutingRuleDao> findByRuleElementsIsEmpty();
}
