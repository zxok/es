package com.example.es.service;

import com.example.es.entity.User;

import java.util.List;


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
 * @time: 2019/9/17
 */
public interface UserService {
    Iterable<User> findAll();

    void save(List<User> list);

    void save(User bean);

    List<User> findByName(String text);

    List<User> findByNameOrDesc(String name, String desc);

    public  List<User> findByDesc(String desc);

    User findById(long id);
}


