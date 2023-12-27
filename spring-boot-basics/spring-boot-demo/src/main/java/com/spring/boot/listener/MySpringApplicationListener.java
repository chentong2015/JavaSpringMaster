package com.spring.boot.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

// Spring在启动的时候
// EventPublishingRunListener publish ApplicationStartingEvent to ApplicationListener
public class MySpringApplicationListener implements ApplicationListener<SpringApplicationEvent> {

    @Override
    public void onApplicationEvent(SpringApplicationEvent event) {
        SpringApplication springApplication = event.getSpringApplication();
        ClassLoader classLoader = springApplication.getClassLoader();
        try {
            // 从指定的类加载器中获取resource资源
            Enumeration<URL> resources = classLoader.getResources("description_json");
            if (!resources.hasMoreElements()) {
                throw new FileNotFoundException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
