package com.example.es.service;

import com.example.es.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Hzx
 */
public interface IProductService {

    /**
     * 查询所有数据
     * @return
     */
    Iterable<Product> findAll();

    /**
     * 根据名称搜索
     * @param name
     * @return
     */
    Iterable<Product> findByName(String name);

    /**
     * @return
     */
    long count();

    /**
     * 添加一条记录
     *
     * @param product
     * @return
     */
    Product add(Product product);

    /**
     * 批量添加
     *
     * @param list
     */
    boolean addAll(List<Product> list) throws Exception;

    /**
     * 删除索引
     *
     * @param product
     */
    void delete(Product product);

    /**
     * 分页查询
     *
     * @param pageNo
     * @param pageSize
     * @param kw
     * @return
     */
    //Page<Product> pageQuery(Integer pageNo, Integer pageSize, String kw);
    Iterable<Product> pageQuery(Integer pageNo, Integer pageSize, String kw);

    /**
     * 创建索引
     */
    void createIndex();

    /**
     * 删除索引
     *
     * @param index
     */
    void deleteIndex(String index);

}
