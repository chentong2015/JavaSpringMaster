package com.example.aop.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_race")
public class Race {

    @Id
    @Column(name = "number")
    private Long number;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    // Save Horses entity while creating race entity
    // Fetch Horses list while retrieving race object
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Horses> horsesList;

    public Race() {
    }

    public Race(Long number, String name, Date date, List<Horses> horsesList) {
        this.number = number;
        this.name = name;
        this.date = date;
        this.horsesList = horsesList;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Horses> getHorsesList() {
        return horsesList;
    }

    public void setHorsesList(List<Horses> horsesList) {
        this.horsesList = horsesList;
    }
}
