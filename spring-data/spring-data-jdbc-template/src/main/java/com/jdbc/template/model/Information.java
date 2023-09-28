package com.jdbc.template.model;

public class Information {

    private int id;
    private String name;
    private String place;
    private int year;

    public Information(int id, String name, String place, int year) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.year = year;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", year=" + year +
                '}';
    }
}
