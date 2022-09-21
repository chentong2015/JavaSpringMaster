package com.spring.data.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringBootMasterConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/hibernate_demo");

        // dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // dataSource.setUsername("test");
        // dataSource.setPassword("TCHong17");
        // dataSource.setUrl("jdbc:sqlserver://driver_name:1433;Database=test_db;Trusted_Connection=true;");
        return dataSource;
    }
}
