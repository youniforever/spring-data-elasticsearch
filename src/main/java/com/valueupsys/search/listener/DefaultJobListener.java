package com.valueupsys.search.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;


@Slf4j
@Component("c.p.t.Listener")
public class DefaultJobListener extends JobExecutionListenerSupport {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("Job JOB START");
        super.beforeJob(jobExecution);
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("Job JOB END");
        super.afterJob(jobExecution);
    }
}
