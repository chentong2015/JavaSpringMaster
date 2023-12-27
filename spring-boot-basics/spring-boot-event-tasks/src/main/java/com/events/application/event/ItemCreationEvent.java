package com.events.application.event;

import org.springframework.context.ApplicationEvent;

public class ItemCreationEvent extends ApplicationEvent {

    private String name;

    public ItemCreationEvent(Object source, String name) {
        super(source);
        this.name = name;
    }
}
