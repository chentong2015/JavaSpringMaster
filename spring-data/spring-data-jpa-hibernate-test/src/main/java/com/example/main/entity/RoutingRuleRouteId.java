package com.example.main.entity;

import javax.persistence.Column;
import java.io.Serializable;

public class RoutingRuleRouteId implements Serializable {

    @Column(name = "ROUTING_RULE_ID")
    private long routingRuleId;

    @Column(name = "ROUTE_ID")
    private long routeId;

    @Column(name = "BLACKLISTED_PORTFOLIO")
    private String blacklistedPortfolio;
    
    public RoutingRuleRouteId() {
    }

    public RoutingRuleRouteId(long routingRuleId, long routeId, String blacklistedPortfolio) {
        this.routingRuleId = routingRuleId;
        this.routeId = routeId;
        this.blacklistedPortfolio = blacklistedPortfolio;
    }


    public long getRoutingRuleId() {
        return routingRuleId;
    }

    public void setRoutingRuleId(long routingRuleId) {
        this.routingRuleId = routingRuleId;
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public String getBlacklistedPortfolio() {
        return blacklistedPortfolio;
    }

    public void setBlacklistedPortfolio(String blacklistedPortfolio) {
        this.blacklistedPortfolio = blacklistedPortfolio;
    }
}
