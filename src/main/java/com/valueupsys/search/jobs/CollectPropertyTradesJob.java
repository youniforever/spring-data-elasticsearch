package com.valueupsys.search.jobs;

import com.valueupsys.search.listener.DefaultJobListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CollectPropertyTradesJob {

    private final String JOB_NAME = "COLLECT-PROPERTY-TRADES";

    private final JobBuilderFactory jobBuilderFactory;

    public CollectPropertyTradesJob(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job collectPropertyTrades(
            @Qualifier("c.p.t.Listener") DefaultJobListener defaultJobListener,
            @Qualifier("c.p.t.Step") Step collectPropertyTradesStep
    ) {
        return jobBuilderFactory.get(JOB_NAME)
                .listener(defaultJobListener)
                .start(collectPropertyTradesStep)
                .build();
    }
}