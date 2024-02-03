package com.events.application.publisher;

import com.events.application.event.ItemCreationEvent;
import com.events.application.event.ItemRemovedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {

    private final ApplicationEventPublisher publisher;

    @Autowired
    EventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    // 通过Publisher发布器来发布指定的事件
    public void publishEvent(final String name) {
        publisher.publishEvent(new ItemCreationEvent(this, name));
        publisher.publishEvent(new ItemRemovedEvent(name));
    }
}
