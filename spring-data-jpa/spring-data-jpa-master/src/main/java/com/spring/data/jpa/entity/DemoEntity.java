package com.spring.data.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_demo")
public class DemoEntity {

    @Id
    @GeneratedValue(generator = "increment")
    private int id;

    @Column(name = "name")
    private String name;

    public DemoEntity() {
    }

    public DemoEntity(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
