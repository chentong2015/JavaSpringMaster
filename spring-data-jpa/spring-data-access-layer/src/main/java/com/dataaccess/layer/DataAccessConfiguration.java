package com.dataaccess.layer;

import com.dataaccess.lagacy.LegacySpringApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:/config/rest-datalayer-default.properties")
public class DataAccessConfiguration {

    @Bean
    public MyBean testEnvironmentAndCreateBean(Environment environment) {
        System.out.println(environment.getProperty("key.name"));

        System.out.println(environment.getProperty("spring.liquibase.enabled"));

        System.out.println(System.getProperty("key.name"));
        System.out.println(System.getProperty("key2"));
        return new MyBean();
    }

    @Bean
    LegacySpringApplicationContext legacySpringApplicationContext() {
        return new LegacySpringApplicationContext();
    }

}
