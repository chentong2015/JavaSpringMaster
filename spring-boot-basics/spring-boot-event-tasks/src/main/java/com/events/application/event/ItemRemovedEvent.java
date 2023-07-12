package com.events.application.event;

// Since Spring 4.2
// we can also publish objects as an event without extending ApplicationEvent
public class ItemRemovedEvent {

    private String name;

    public ItemRemovedEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
