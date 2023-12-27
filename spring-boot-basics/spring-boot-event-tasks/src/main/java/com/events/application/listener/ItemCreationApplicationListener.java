package com.events.application.listener;

import com.events.application.event.ItemCreationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// ApplicationListener监听的事件必须继承自ApplicationEvent
@Component
public class ItemCreationApplicationListener implements ApplicationListener<ItemCreationEvent> {

    @Override
    public void onApplicationEvent(ItemCreationEvent event) {
        System.out.println("handle item creation event");
    }
}
