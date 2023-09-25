package com.spring.jdbc.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.spring.jdbc")
public class SpringJdbcConfig {

    // 这里注入的DataSource需要传递给JdbcTemplate用于连接到指定的DB
    @Bean
    @Qualifier("mysql-datasource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_db?useSSL=false");
        return dataSource;
    }

    // TODO: 使用具有dbcp连接池中的DataSource类型
    // @Bean
    public DataSource dataSource1(JdbcProperties jdbcProperties) {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUsername(jdbcProperties.getUsername());
        basicDataSource.setPassword(jdbcProperties.getPassword());
        basicDataSource.setUrl(jdbcProperties.getUrl());
        // driver-class-name可以不提供，Spring Boot能够自动从URL推断
        basicDataSource.setDriverClassName(jdbcProperties.getDriverClassName());
        return basicDataSource;
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
