package com.example.aop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_horses")
public class Horses {

    @Id
    @Column(name = "number")
    private Long number;

    @Column(name = "name")
    private String name;

    public Horses() {
    }

    public Horses(Long number, String name) {
        this.number = number;
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
