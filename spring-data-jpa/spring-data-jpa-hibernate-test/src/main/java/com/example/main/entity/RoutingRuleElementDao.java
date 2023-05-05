package com.example.main.entity;

import javax.persistence.*;

@Entity
@Table(name = "DDB_ROUTING_RULE_ELEMENT")
public class RoutingRuleElementDao {

    @EmbeddedId
    private RoutingRuleElementId id;

    @ManyToOne
    @MapsId("routingRuleId")
    private RoutingRuleDao routingRule;

    public RoutingRuleElementDao() {
    }

    public RoutingRuleElementId getId() {
        return id;
    }

    public void setId(RoutingRuleElementId id) {
        this.id = id;
    }

    public RoutingRuleDao getRoutingRule() {
        return routingRule;
    }

    public void setRoutingRule(RoutingRuleDao routingRule) {
        this.routingRule = routingRule;
    }

}
