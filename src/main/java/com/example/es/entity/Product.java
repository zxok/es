package com.example.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: es
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2021-03-10 17:16
 **/
@Data
//indexName索引库名称  type是类型 等价于mysql的库和表
@Document(indexName = "product")
public class Product implements Serializable {
    @Id
    private String productId;
    // 配置分词器，字段类型，可以不配置，默认也可
    //Field是其他元素字段，index是否索引，store是否保存原文
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String name;
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String brand;
    private Integer category;
    private Double price;
    private Integer stock;
}
