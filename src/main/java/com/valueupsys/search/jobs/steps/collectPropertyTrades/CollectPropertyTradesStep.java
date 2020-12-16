package com.valueupsys.search.jobs.steps.collectPropertyTrades;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CollectPropertyTradesStep {

    private final Integer CHUNK_SIZE = 10;

    private final StepBuilderFactory stepBuilderFactory;

    public CollectPropertyTradesStep(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @JobScope
    @Bean("c.p.t.Step")
    public Step collectPropertyTradesStep(
            @Qualifier("c.p.t.Reader") ItemReader reader,
            @Qualifier("c.p.t.Processor") ItemProcessor processor,
            @Qualifier("c.p.t.Writer") ItemWriter writer
    ) {
        return stepBuilderFactory.get("collectPropertyTrades Step")
                .<Integer, Integer>chunk(CHUNK_SIZE)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
