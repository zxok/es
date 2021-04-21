package com.example.es.dao;

import com.example.es.entity.Product;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Hzx
 */
@Repository
public interface ProductDao extends ElasticsearchRepository<Product,String> {

    Iterable<Product> findByName(String name);

    @Override
    long count();

    /*@Override
    <S extends Product> S index(S s);

    @Override
    Iterable<Product> search(QueryBuilder queryBuilder);

    @Override
    Page<Product> search(QueryBuilder queryBuilder, Pageable pageable);

    @Override
    Page<Product> search(SearchQuery searchQuery);

    @Override
    Page<Product> searchSimilar(Product product, String[] strings, Pageable pageable);

    @Override
    void refresh();

    @Override
    Class<Product> getEntityClass();

    @Override
    Iterable<Product> findAll(Sort sort);

    @Override
    Page<Product> findAll(Pageable pageable);

    @Override
    <S extends Product> S save(S s);

    @Override
    <S extends Product> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    Optional<Product> findById(String s);

    @Override
    boolean existsById(String s);

    @Override
    Iterable<Product> findAll();

    @Override
    Iterable<Product> findAllById(Iterable<String> iterable);

    @Override
    long count();

    @Override
    void deleteById(String s);

    @Override
    void delete(Product product);

    @Override
    void deleteAll(Iterable<? extends Product> iterable);

    @Override
    void deleteAll();*/
}
