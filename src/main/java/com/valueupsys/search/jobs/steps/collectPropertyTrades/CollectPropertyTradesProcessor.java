package com.valueupsys.search.jobs.steps.collectPropertyTrades;

import com.valueupsys.search.common.entities.Article;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Random;

@Configuration
public class CollectPropertyTradesProcessor {
    @StepScope
    @Bean("c.p.t.Processor")
    protected ItemProcessor<Article, Article> collectPropertyTradesReader() {
        return item -> {
            int rand = new Random().nextInt(100);
            item.setTitle(rand);
            item.setTime(Instant.now().getEpochSecond() * 1000L);
            Thread.sleep(500);
            return item;
        };
    }
}
