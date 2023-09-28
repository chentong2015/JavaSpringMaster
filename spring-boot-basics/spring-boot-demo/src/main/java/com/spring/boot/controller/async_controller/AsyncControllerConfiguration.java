package com.spring.boot.controller.async_controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncControllerConfiguration {

    // 使用线程池来运行并发的线程，设置最大并发线程数和阻塞队列
    // Define the thread pool, and limit the number of concurrent threads to 10
    @Bean(name = "asyncTaskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("Server thread:");
        executor.initialize();
        return executor;
    }
}
