package demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class ApplicationTransactionConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        return new LocalContainerEntityManagerFactoryBean();
    }

    // 自定义配置Jpa Transaction相关属性
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        // transactionManager.setPersistenceUnitName();
        // transactionManager.setDataSource();
        // transactionManager.setJpaDialect();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
