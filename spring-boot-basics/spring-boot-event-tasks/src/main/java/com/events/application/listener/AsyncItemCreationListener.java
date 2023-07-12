package com.events.application.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

// TODO. 异步监听器
// By default spring events are synchronous, publisher thread blocks until all listeners have finished processing events.
// 1. @Async 异步监听
// 2. @EnableAsync 开启异步监听功能
@Component
public class AsyncItemCreationListener {

    //  @Configuration classes or the @SpringBootApplication class with @EnableAsync.
    @Async
    @EventListener
    public void handleAsyncEvent(String event) {
        // handle event
    }
}
