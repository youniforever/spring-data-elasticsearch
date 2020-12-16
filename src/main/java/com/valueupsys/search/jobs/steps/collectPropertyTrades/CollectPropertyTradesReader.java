package com.valueupsys.search.jobs.steps.collectPropertyTrades;

import com.valueupsys.search.common.entities.Article;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Configuration
public class CollectPropertyTradesReader {
    @StepScope
    @Bean("c.p.t.Reader")
    protected ItemReader<? extends Article> collectPropertyTradesReader() {
        List<Article> collect = IntStream.range(0, 10000)
                .mapToObj(operand -> new Article()).collect(Collectors.toList());
        return new ListItemReader<>(collect);
    }
}
