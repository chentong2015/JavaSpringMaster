package com.aspectj.template.config;

import com.aspectj.template.aspect.TracingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracingAspectConfiguration {

    @Bean
    TracingAspect tracingAspect() {
        return new TracingAspect();
    }
}
