package com.example.manager.Config.Batch;

import org.springframework.batch.core.JobExecution;

public interface JobExecutionListener {

    void beforeJob(JobExecution jobExecutionListener);
    void afterJob(JobExecution jobExecutionListener);
}
