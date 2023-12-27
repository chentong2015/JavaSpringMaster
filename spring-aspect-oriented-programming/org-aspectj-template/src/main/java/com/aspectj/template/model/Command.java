package com.aspectj.template.model;

public class Command {

    private final int id;
    private final String label;

    public Command(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
}
