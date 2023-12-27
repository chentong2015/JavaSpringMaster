package com.events.application.listener.async;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

// TODO. 异步监听器的两种实现方式
// By default spring events are synchronous, publisher thread blocks until all listeners have finished processing events.
// 1. @Async 异步监听
// 2. @EnableAsync 开启异步监听功能
//    @Configuration classes or the @SpringBootApplication class with @EnableAsync.
@Component
public class AsyncItemCreationListener {

    @Async
    @EventListener
    public void handleAsyncEvent(String event) {
        // handle event
    }
}
