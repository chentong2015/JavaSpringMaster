package com.example.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfig {

    @Bean
    public DataSource getAnotherDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // dataSource.setDriverClassName("org.postgresql.Driver");
        // dataSource.setUsername("postgres");
        // dataSource.setPassword("admin");
        // dataSource.setUrl("jdbc:postgresql://localhost:5432/hibernate_demo");

        dataSource.setDriverClassName("com.sybase.jdbc4.jdbc.SybDriver");
        dataSource.setUsername("INSTAL");
        dataSource.setPassword("INSTALL");
        dataSource.setUrl("jdbc:sybase:Tds:dell719xxx:4100/JAVA_INT_TESTS");
        return dataSource;
    }
}

