package com.dataaccess.layer;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

/**
 * 1. set the Spring application's configuration to disable liquibase by default at spring boot app starting time
 * 2. set a new naming strategy for hibernate/jpa.
 */
public final class DataAccessAppListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment environment = event.getEnvironment();
        Properties props = new Properties();
        props.put("spring.liquibase.enabled", "false");
        props.put("spring.jpa.properties.hibernate.id.new_generator_mappings", "false");
        environment.getPropertySources().addFirst(new PropertiesPropertySource("das_properties", props));
    }
}
