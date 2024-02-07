package demo.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourcePoolConfig {

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
}
