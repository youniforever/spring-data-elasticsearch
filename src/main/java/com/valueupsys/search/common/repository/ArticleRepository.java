package com.valueupsys.search.common.repository;

import com.valueupsys.search.common.entities.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleRepository extends ElasticsearchRepository<Article, String> {
}
