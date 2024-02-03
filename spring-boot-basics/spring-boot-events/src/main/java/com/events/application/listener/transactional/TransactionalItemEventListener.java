package com.events.application.listener.transactional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class TransactionalItemEventListener {

    // 监听器只会在调用方为事务方法时执行，如果调用方是非事务方法，则无法该监听器不会被通知
    // 通过设置fallbackExecution=true，可以让Listener在任何情况都可以执行
    @TransactionalEventListener
    public void handleTransactionalEvent(String event) {

    }
}
