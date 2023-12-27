package com.spring.data.jpa.converter;

public class PersonName {

    private String name;
    private String surname;

    public PersonName() {
    }

    public PersonName(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
