package com.valueupsys.search.common.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Document(indexName = "article-#{T(java.time.LocalDate).now().toString()}")
public class Article {
    @Id
    private String id;

    @Field(type = FieldType.Integer)
    private Integer title;

    @Field(type = FieldType.Date, format = DateFormat.custom)
    private Long time;
}
