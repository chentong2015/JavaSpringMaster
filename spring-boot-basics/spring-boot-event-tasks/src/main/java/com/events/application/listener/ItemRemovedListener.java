package com.events.application.listener;

import com.events.application.event.ItemRemovedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ItemRemovedListener {

    // TODO. @EventListener标记的方法必须是公开的方法(被proxy代理调用，必须保证是public)
    @EventListener // (condition = "#event.name eq 'reflectoring'")
    public void handleUserRemovedEvent(ItemRemovedEvent event) {
        System.out.println(event.getName());
        System.out.println("handle removed event");
    }

    // 使用注解声明要监听的事件类型
    @EventListener(ItemRemovedEvent.class)
    public void handleUserRemovedEventPlus() {
        System.out.println("target removed event");
    }
}
