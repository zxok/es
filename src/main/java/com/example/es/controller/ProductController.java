package com.example.es.controller;

import com.example.es.entity.Product;
import com.example.es.service.IProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: es
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2021-03-10 17:21
 **/
@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    IProductService productService;

    @GetMapping("test")
    public String test() {
        return "ProductController-test";
    }

    @GetMapping("page")
    public Iterable<Product> page(Integer pageNo, Integer pageSize, String kw) {
        return productService.pageQuery(pageNo,pageSize,kw);
    }

    @GetMapping("findAll")
    public Iterable<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("findByName")
    public Iterable<Product> findByName(String name) {
        return productService.findByName(name);
    }

    @PostMapping("add")
    public Product addProduct(Product product) {
        return productService.add(product);
    }

    @PutMapping("addIndex")
    public boolean createIndex() {
        productService.createIndex();
        return true;
    }

    @DeleteMapping("delIndex")
    public boolean deleteIndex() {
        productService.deleteIndex("1");
        return true;
    }



}
