package com.spring.model;

public class BeanDefinition {

    private Class clazz;
    private String scope;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isSingleton() {
        return scope.equals("singleton");
    }

    public boolean isPrototype() {
        return scope.equals("prototype");
    }

}
