package com.example.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


import java.io.Serializable;

/**
 * @program: es
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2021-03-10 17:16
 **/
@Data
@Document(indexName = "product")
public class Product implements Serializable {
    @Id
    private String productId;
    private String name;
    private String category;
    private Integer price;
    private String brand;
    private Integer stock;
}
