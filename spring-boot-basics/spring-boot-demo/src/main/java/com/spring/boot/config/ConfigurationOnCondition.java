package com.spring.boot.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// @ConditionalOnProperty 只有满足指定环境property属性设置才会注入配置中的beans
// matchIfMissing=true    即使属性条件不满足仍然match并注入
@Configuration
@ConditionalOnProperty(value = "isEnabled", havingValue = "true", matchIfMissing = false)
public class ConfigurationOnCondition {

    // -DisEnabled=true
    @Bean
    public MyConditionalBean myConditionalBean() {
        System.out.println("Inject conditional bean");
        return new MyConditionalBean();
    }

    // TODO: 使用具有dbcp连接池中的DataSource类型
    @Bean
    public DataSource dataSource1(JdbcProperties jdbcProperties) {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUsername(jdbcProperties.getUsername());
        basicDataSource.setPassword(jdbcProperties.getPassword());
        basicDataSource.setUrl(jdbcProperties.getUrl());
        // driver-class-name可以不提供，Spring Boot能够自动从URL推断
        basicDataSource.setDriverClassName(jdbcProperties.getDriverClassName());
        return null;
    }

    class MyConditionalBean {

        private int id;
        private String name;

        public MyConditionalBean() {
        }

        public MyConditionalBean(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
