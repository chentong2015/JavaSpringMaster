package com.springboot.client;

import com.springboot.api.DemoClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

    @Bean
    public DemoClass demoClass() {
        return new DemoClass("Client New Name");
    }
}
