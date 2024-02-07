package com.events.application;

import org.springframework.context.SmartLifecycle;

// Spring应用启动和关闭的监听器
// Lifecycle interface for listening to application startup and shutdown.
public class SpringAppLifecycleListener implements SmartLifecycle {

    private volatile boolean running;

    @Override
    public void start() {
        running = true;
        onApplicationStart();
    }

    @Override
    public void stop() {
        running = false;
        onApplicationStop();
    }

    // 在结束的时候，调用回调函数的执行逻辑
    @Override
    public void stop(Runnable callback) {
        try {
            callback.run();
        } finally {
            stop();
        }
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    protected void onApplicationStart() {
        // do something when spring application starts
    }

    protected void onApplicationStop() {
        // do something when spring application stops
    }
}
