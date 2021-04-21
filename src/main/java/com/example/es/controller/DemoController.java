package com.example.es.controller;

import com.example.es.dao.ProductDao;
import com.example.es.dao.UserDao;
import com.example.es.entity.Product;
import com.example.es.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: es
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2021-04-16 16:02
 **/
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    UserDao userDao;

    /**
     *  DAO
     */
    @Resource
    ProductDao productDao;

    @GetMapping("test1")
    public Iterable<Product> test1(Integer from, Integer to) {
        //创建查询体
        /*BoolQueryBuilder builder = QueryBuilders.boolQuery();
        //设置聚合条件
        RangeQueryBuilder query = QueryBuilders.rangeQuery("productId").from(2).to(1);
        //将聚合条件设置入查询体之中
        builder.must(query);*/

        QueryBuilder builder = QueryBuilders.rangeQuery("productId").from(from).to(to);
        Iterable<Product> search = productDao.search(builder);
        log.error(search.toString());

        QueryBuilder qb1 = QueryBuilders.termsQuery("name", "demoData");
        Iterable<Product> search1 = productDao.search(qb1);

        long count = productDao.count();
        log.error("count: "+count);

        Pageable page = new QPageRequest(from,to);
        Iterable<Product> pageData = productDao.findAll(page);

        /*Pageable page = new QPageRequest(1,1);
        Iterable<Product> all = productDao.findAll(page);*/

        return search;
    }

    /**
     * 分页搜索
     * @param current   页码（从0开始）
     * @param size      每页的数据量
     * @param keywords  搜索的关键字
     * @return
     */
    @GetMapping("test2")
    public Iterable<User> test2(@RequestParam(defaultValue = "0") Integer current, @RequestParam(defaultValue = "10")Integer size, String keywords) {
        //设分页置
        Pageable pageable = PageRequest.of(current, size);
        //排序设置
        SortBuilder sortBuilder = new FieldSortBuilder("age").order(SortOrder.ASC);

        //分页设置参数装配
        SearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.multiMatchQuery(keywords, "desc"))
                //.withHighlightFields(new HighlightBuilder.Field(field))
                //.withSort(sortBuilder)
                .withPageable(pageable)
                .build();

        //获取分页数据
        return userDao.search(query);
    }

}
