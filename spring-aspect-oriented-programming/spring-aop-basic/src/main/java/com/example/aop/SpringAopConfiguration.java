package com.example.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

// @EnableAspectJAutoProxy(proxyTargetClass = false, exposeProxy = false)
// 1. proxyTargetClass = false 默认使用JdkDynamicAopProxy，而不是cglib代理
// 2. exposeProxy = false 默认不将Proxy暴露给ThreadLocal，无法通过AopContext.currentProxy()获取
@Configuration
@EnableAspectJAutoProxy
public class SpringAopConfiguration {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/pmu_database");
        return dataSource;
    }
}
