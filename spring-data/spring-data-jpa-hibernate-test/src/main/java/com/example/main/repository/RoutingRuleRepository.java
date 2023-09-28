package com.example.main.repository;

import com.example.main.entity.RoutingRuleDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoutingRuleRepository extends CrudRepository<RoutingRuleDao, Long> {

    // hql string -> native sql : 对于不同的数据库都需要执行同一个Native Query
    // select generatedAlias0 from com.example.main.entity.RoutingRuleDao as generatedAlias0 where generatedAlias0.ruleElements is empty
    @Query(value = "select * from ddb_routing_rule where not ( exists " +
            "(select * from ddb_routing_rule_element where ddb_routing_rule.id=ddb_routing_rule_element.routing_rule_id))", nativeQuery = true)
    Optional<RoutingRuleDao> findByRuleElementsIsEmpty();
}
