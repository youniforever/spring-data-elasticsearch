package com.valueupsys.search.jobs.steps.collectPropertyTrades;

import com.valueupsys.search.common.entities.Article;
import com.valueupsys.search.common.repository.ArticleRepository;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CollectPropertyTradesWriter {

    private final ArticleRepository articleRepository;

    public CollectPropertyTradesWriter(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @StepScope
    @Bean("c.p.t.Writer")
    protected ItemWriter<Article> collectPropertyTradesWriter() {
        return items -> {
            articleRepository.saveAll(items);
        };
    }
}
