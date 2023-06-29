package com.dataaccess.main.das;

import com.dataaccess.main.context.LegacySpringApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:/config/rest-datalayer-default.properties")
public class DataAccessConfiguration {

    @Bean
    MyDataSourceFactory myDataSourceFactory() {
        return new MyDataSourceFactory();
    }

    @Bean
    public MyBean testEnvironmentAndCreateBean(Environment environment, MyDataSourceFactory myDataSourceFactory) {
        System.out.println(environment.getProperty("my.property"));

        System.out.println(environment.getProperty("spring.liquibase.enabled"));
        System.out.println(environment.getProperty("key.name"));

        System.out.println(System.getProperty("key.name"));

        myDataSourceFactory.printDataSourceFactory();
        return new MyBean();
    }

    @Bean
    LegacySpringApplicationContext legacySpringApplicationContext() {
        return new LegacySpringApplicationContext();
    }

}
