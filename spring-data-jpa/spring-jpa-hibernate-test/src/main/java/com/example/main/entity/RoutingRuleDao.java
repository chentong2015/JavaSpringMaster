package com.example.main.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "com.example.main.entity.RoutingRuleDao")
@Table(name = "DDB_ROUTING_RULE")
public class RoutingRuleDao {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "LABEL")
    private String label;

    @Column
    private String myNameLabel;

    @OneToMany(mappedBy = "routingRule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoutingRuleRouteDao> ruleRoutes = new ArrayList<>();

    @OneToMany(mappedBy = "routingRule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoutingRuleElementDao> ruleElements = new ArrayList<>();

    public RoutingRuleDao() {
    }

    public long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public List<RoutingRuleRouteDao> getRuleRoutes() {
        return ruleRoutes;
    }

    public List<RoutingRuleElementDao> getRuleElements() {
        return ruleElements;
    }

    public void setRuleElements(List<RoutingRuleElementDao> ruleElements) {
        this.ruleElements = ruleElements;
    }

    public String getMyNameLabel() {
        return myNameLabel;
    }

    public void setMyNameLabel(String myNameLabel) {
        this.myNameLabel = myNameLabel;
    }
}
