package com.spring.batch.config;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

import java.util.List;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    // TODO. Spring Batch 5 老版本构建JOb和Step的方法
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor("spring_batch");
    }

    // 老版本设置线程池来并发执行step
    @Bean
    public Step initIdGenerator() {
        return stepBuilderFactory.get("Init id generator")
                .allowStartIfComplete(true)
                .tasklet(initIdGeneratorTasklet())
                .taskExecutor(taskExecutor())
                .build();
    }

    private Tasklet initIdGeneratorTasklet() {
        return null;
    }


    private NamedParameterJdbcTemplate jdbcTemplate;

    protected void batchUpdate(List<?> list, String sql) {
        if (list != null && !list.isEmpty()) {
            SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(list.toArray());
            jdbcTemplate.batchUpdate(sql, params);
        }
    }
}
