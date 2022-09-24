package demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class ApplicationTransactionConfig {

    // 自定义配置Jpa Transaction相关属性
    // 注入PlatformTransactionManager的同时也需要注入EntityManagerFactory
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        // transactionManager.setPersistenceUnitName();
        // transactionManager.setDataSource();
        // transactionManager.setJpaDialect();
        // transactionManager.setEntityManagerFactory(new LocalContainerEntityManagerFactoryBean().getObject());
        return transactionManager;
    }
}
