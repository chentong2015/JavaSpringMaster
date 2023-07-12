package com.events.application;

import com.events.application.listener.ItemCreationApplicationListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringEventsApplication {

    // TODO. 在Spring Application启动时添加监听器
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringEventsApplication.class);
        springApplication.addListeners(new ItemCreationApplicationListener());
        springApplication.run(args);
    }
}
