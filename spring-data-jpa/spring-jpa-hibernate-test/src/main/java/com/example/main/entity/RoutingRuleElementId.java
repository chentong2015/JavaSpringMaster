package com.example.main.entity;

import javax.persistence.Column;
import java.io.Serializable;

public class RoutingRuleElementId implements Serializable {

    @Column(name = "ROUTING_RULE_ID")
    private long routingRuleId;

    @Column(name = "REGISTRATION_ID")
    private long registrationId;

    @Column(name = "PRODUCT_TYPE_ID")
    private long productTypeId;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "CLOSING_ENTITY_ID")
    private long closingEntityId;

    @Column(name = "IS_PROGRAM_TRADE")
    private boolean programTrade;

    public RoutingRuleElementId() {
    }

    public RoutingRuleElementId(long routingRuleId,
                                long registrationId,
                                long productTypeId,
                                String currency,
                                long closingEntityId,
                                boolean programTrade) {
        this.routingRuleId = routingRuleId;
        this.registrationId = registrationId;
        this.productTypeId = productTypeId;
        this.currency = currency;
        this.closingEntityId = closingEntityId;
        this.programTrade = programTrade;
    }

    public long getRoutingRuleId() {
        return routingRuleId;
    }

    public void setRoutingRuleId(long routingRuleId) {
        this.routingRuleId = routingRuleId;
    }

    public long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(long registrationId) {
        this.registrationId = registrationId;
    }

    public long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getClosingEntityId() {
        return closingEntityId;
    }

    public void setClosingEntityId(long closingEntityId) {
        this.closingEntityId = closingEntityId;
    }

    public boolean isProgramTrade() {
        return programTrade;
    }

    public void setProgramTrade(boolean programTrade) {
        this.programTrade = programTrade;
    }
}
