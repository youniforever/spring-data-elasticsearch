package com.valueupsys.search.jobs.steps.collectPropertyTrades;

import com.valueupsys.search.common.entities.Article;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CollectPropertyTradesProcessor {
    @StepScope
    @Bean("c.p.t.Processor")
    protected ItemProcessor<Article, Article> collectPropertyTradesReader() {
        return item -> item;
    }
}
