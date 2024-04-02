package com.spring.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

// JOB执行的监听器，可以在执行前后完成额外的操作
public class MyJobExecutionListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        String jobName = jobExecution.getJobInstance().getJobName();
        System.out.println(jobName);
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        // job done
    }
}
