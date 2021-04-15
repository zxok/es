package com.example.es.service.impl;

import com.example.es.dao.ProductDao;
import com.example.es.entity.Product;
import com.example.es.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: es
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2021-03-10 17:17
 **/
@Service
public class ProductServiceImpl implements IProductService {

    @Resource
    ProductDao productDao;

    @Override
    public Iterable<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Product add(Product product) {
        return productDao.save(product);
    }

    @Override
    public boolean addAll(List<Product> list) throws Exception {
        return false;
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public Iterable<Product> getList() {
        return null;
    }

    @Override
    public List<Product> getByName(String name) {
        return null;
    }

    @Override
    public Page<Product> pageQuery(Integer pageNo, Integer pageSize, String kw) {
        return null;
    }

    @Override
    public void createIndex() {

    }

    @Override
    public void deleteIndex(String index) {

    }
}
