package com.springboot.server;

import com.springboot.api.DemoClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ServerConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public DemoClass demoClass() {
        return new DemoClass("Server By Default");
    }
}
