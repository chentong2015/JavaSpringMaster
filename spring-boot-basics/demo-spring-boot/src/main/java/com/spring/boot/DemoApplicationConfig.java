package com.spring.boot;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

@Configuration
public class DemoApplicationConfig {

    // 在程序关闭之前所执行的逻辑
    @PreDestroy
    public void onShutDown() {
        System.out.println("closing application context..cleanup");
    }
}
