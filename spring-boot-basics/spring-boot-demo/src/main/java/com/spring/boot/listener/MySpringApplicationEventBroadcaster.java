package com.spring.boot.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

// APP事件的一个广播器
public class MySpringApplicationEventBroadcaster
        implements ApplicationListener<SpringApplicationEvent> {

    // 所有的事件监听器的集合
    private final AppEventListener[] springApplicationEventListeners;

    MySpringApplicationEventBroadcaster(AppEventListener... listeners) {
        super();
        this.springApplicationEventListeners = listeners.clone();
    }

    @Override
    public void onApplicationEvent(SpringApplicationEvent event) {
        if (event instanceof ApplicationReadyEvent) {
            onSuccess(event.getSpringApplication(), ((ApplicationReadyEvent) event).getApplicationContext());
        } else if (event instanceof ApplicationFailedEvent) {
            onFailure(event.getSpringApplication(), ((ApplicationFailedEvent) event).getException());
        }
    }

    private void onSuccess(SpringApplication springApplication,
                           ConfigurableApplicationContext configurableApplicationContext) {
        for (AppEventListener listener : this.springApplicationEventListeners) {
            listener.onSuccess(springApplication, configurableApplicationContext);
        }
    }

    private void onFailure(SpringApplication springApplication, Throwable cause) {
        for (AppEventListener listener : this.springApplicationEventListeners) {
            listener.onFailure(springApplication, cause);
        }
    }
}
