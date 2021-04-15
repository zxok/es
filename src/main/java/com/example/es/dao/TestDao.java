package com.example.es.dao;

import com.example.es.entity.TestBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * @author: pyfysf
 * <p>
 * @qq: 337081267
 * <p>
 * @CSDN: http://blog.csdn.net/pyfysf
 * <p>
 * @blog: http://wintp.top
 * <p>
 * @email: pyfysf@163.com
 * <p>
 * 继承CRUD，第一个泛型是实体类类型，第二个泛型是id的类型
 */
@Repository
public interface TestDao extends CrudRepository<TestBean, Long> {
    List<TestBean> findByName(String name);

    List<TestBean> findByDesc(String desc);

    List<TestBean> findByNameOrDesc(String name,String desc);

    @Override
    Optional<TestBean> findById(Long aLong);
}


