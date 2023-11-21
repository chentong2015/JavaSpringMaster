package com.spring.batch.components;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

// JobExecution Listener 监测每个Job执行的过程(异常以及完成通知)
@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

    // Spring JdbcTemplate 执行和DB有关的操作, 查询数据时需要使用RowMapper
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println(jobExecution.getJobId());
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            System.out.println("!!! JOB FINISHED! Time to verify the results");

            String query = "SELECT first_name, last_name FROM people";
            jdbcTemplate.query(query, new PersonRowMapper()).forEach(
                    person -> System.out.println("Found person in the database."));
        } else if (jobExecution.getStatus() == BatchStatus.FAILED) {
            jobExecution.getFailureExceptions();
        }
    }
}
