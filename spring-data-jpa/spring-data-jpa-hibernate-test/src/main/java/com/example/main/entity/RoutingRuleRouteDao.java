package com.example.main.entity;

import javax.persistence.*;

@Entity
@Table(name = "DDB_ROUTING_RULE_ROUTE")
public class RoutingRuleRouteDao {

    @EmbeddedId
    private RoutingRuleRouteId id;

    @ManyToOne
    @MapsId("routingRuleId")
    private RoutingRuleDao routingRule;

    public RoutingRuleRouteDao() {
    }

    public RoutingRuleRouteDao(long routeId,
                               String blacklistedPortfolio,
                               RoutingRuleDao routingRuleDao) {
        this.id = new RoutingRuleRouteId(routingRuleDao.getId(), routeId, blacklistedPortfolio);
        this.routingRule = routingRuleDao;
    }

    public RoutingRuleRouteId getId() {
        return id;
    }

    public void setId(RoutingRuleRouteId id) {
        this.id = id;
    }

    public RoutingRuleDao getRoutingRule() {
        return routingRule;
    }

    public void setRoutingRule(RoutingRuleDao routingRule) {
        this.routingRule = routingRule;
    }
}
