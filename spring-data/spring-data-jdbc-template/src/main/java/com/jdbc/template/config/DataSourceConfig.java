package com.jdbc.template.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    // 这里注入的DataSource需要传递给JdbcTemplate用于连接到指定的DB
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/hibernate_demo");
        return dataSource;
    }

    // TODO. 配置JNDI DataSource数据源
    // 1. .setResourceRef(true) 设置"相对路径"引用, 反之使用"java:comp/env/jdbc/dataSourceName"
    // 2. .getDataSource(name)  直接使用Tomcat context.xml配置文件中dataSourceName名称来获取数据资源
    // @Bean
    public DataSource dataSource2() {
        final JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
        dataSourceLookup.setResourceRef(true);
        DataSource dataSource = dataSourceLookup.getDataSource("jdbc/myDataSource");
        return dataSource;
    }

    // 根据不同的配置策略来激活指定的配置
    // @Bean
    // @ConditionalOnProperty(prefix="routing", name="strategy", havingValue="RoutingDsAndTbStrategy")
    // public ICtongRouting routingDsAndTbStrategy() {
    //     return new RoutingDsAndTbStrategy();
    // }
}
