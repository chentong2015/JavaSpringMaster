package com.spring.batch.config;

public class BatchCoreConfiguration {

    // 以下的bean会被Batch自动装配进行注入
    // [org/springframework/boot/autoconfigure/batch/BatchAutoConfiguration$SpringBootBatchConfiguration.class]
    //
    // @Bean(name = "jobRepository")
    // public JobRepository getJobRepository() throws Exception {
    //     JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
    //     factory.setDataSource(dataSource());
    //     factory.setTransactionManager(getTransactionManager());
    //     factory.afterPropertiesSet();
    //     return factory.getObject();
    // }
    //
    // @Bean(name = "transactionManager")
    // public PlatformTransactionManager getTransactionManager() {
    //    return new ResourcelessTransactionManager();
    // }
}
