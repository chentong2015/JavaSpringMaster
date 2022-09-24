package com.spring.tester1.model;

import java.io.Serializable;

public class Product implements Serializable {

    private String id;
    private String name;

    // TODO. 需要带有默认的构造器，在POST请求中能够自动构建model的object

    //public Product(String id, String name) {
    //    this.id = id;
    //    this.name = name;
    //}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
