package com.events.application.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

// At spring boot app starting time
// 1. set the Spring application's configuration to disable liquibase by default
// 2. set a new naming strategy for hibernate/jpa.
public final class DataAccessApplicationListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    // TODO. 配置META-INF/spring.factories文件来触发这里的event
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        System.out.println("invoke the application event !");
        ConfigurableEnvironment environment = event.getEnvironment();
        Properties props = new Properties();
        props.put("my.property", "false");
        props.put("spring.jpa.properties.hibernate.id.new_generator_mappings", "false");

        // TODO. 获取到App启动时所有配置的属性properties
        environment.getPropertySources().addLast(new PropertiesPropertySource("hello_properties", new Properties()));
        environment.getPropertySources().addFirst(new PropertiesPropertySource("test_properties", props));
    }
}
