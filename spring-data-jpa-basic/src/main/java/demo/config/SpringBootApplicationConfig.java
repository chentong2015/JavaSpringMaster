package demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
// @EnableTransactionManagement
public class SpringBootApplicationConfig {

    // TODO: 从配置文件中自动加载配置的信息，完成DataSource的设置
    // ?allowPublicKeyRetrieval=true?useSSL=false
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        dataSource.setUrl("jdbc:mysql://localhost:3306/dbspringboot");
        return dataSource;
    }

    // 使用DataSourceBuilder构建DataSource
    // @Bean
    // public DataSource dataSource2() {
    //     DataSourceBuilder builder = DataSourceBuilder.create();
    //     builder.url("jdbc:mysql://localhost:3306/dbspringboot");
    //     return builder.build();
    // }
}

