package com.example.es.service.impl;

import com.example.es.dao.ProductDao;
import com.example.es.entity.Product;
import com.example.es.service.IProductService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: es
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2021-03-10 17:17
 **/
@Service
public class ProductServiceImpl implements IProductService {

    /**
     *  DAO
     */
    @Resource
    ProductDao productDao;

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public Iterable<Product> findAll() {
        return productDao.findAll();
    }

    /**
     * 根据名称搜索
     * @param name
     * @return
     */
    @Override
    public Iterable<Product> findByName(String name) {
        return productDao.findByName(name);
    }

    /**
     * 数据总量
     * @return
     */
    @Override
    public long count() {
        return productDao.count();
    }

    /**
     * 添加一条记录
     * @param product
     * @return
     */
    @Override
    public Product add(Product product) {
        return productDao.save(product);
    }

    /**
     * 批量添加
     * @param list
     */
    @Override
    public boolean addAll(List<Product> list) throws Exception {
        return false;
    }

    /**
     * 删除索引
     * @param product
     */
    @Override
    public void delete(Product product) {

    }

    /**
     * 分页查询
     * @return
     */
    @Override
    public Iterable<Product> pageQuery(Integer current, Integer size, String keywords) {
        if (ObjectUtils.isEmpty(current)) {
            current = 1;
        }
        if (ObjectUtils.isEmpty(size)) {
            size = 10;
        }

        Pageable pageable = PageRequest.of(current, size);
        SortBuilder sortBuilder = new FieldSortBuilder("name").order(SortOrder.ASC);

        SearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.multiMatchQuery(keywords, "name"))
                //.withHighlightFields(new HighlightBuilder.Field(field))
                //.withSort(sortBuilder)
                .withPageable(pageable)
                .build();

        Page<Product> data = productDao.search(query);

        return data;
    }

    /**
     * 创建索引
     */
    @Override
    public void createIndex() {
        productDao.index(new Product());
    }

    /**
     * 删除索引
     * @param index
     */
    @Override
    public void deleteIndex(String index) {

    }
}
