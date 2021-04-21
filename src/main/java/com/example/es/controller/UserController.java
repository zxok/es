package com.example.es.controller;


import com.example.es.entity.User;
import com.example.es.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
 */
@RestController
@RequestMapping("/testes")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("findAll")
    public Iterable<User> findAll() {
        return userService.findAll();
    }

    /**
     *  添加模拟数据
     */
    @RequestMapping("list")
    public String save() {
        List<User> list = null;
        userService.save(list);
        return "success";
    }

    /**
     * 添加
     * @param bean
     */
    @RequestMapping("save")
    public String save(User bean) {
        userService.save(bean);
        return "OK";
    }

    @RequestMapping("findByName")
    public List<User> findByName(String name) {
        return userService.findByName(name);
    }

    @RequestMapping("findByNameOrDesc")
    public List<User> findByNameOrDesc(String name, String desc) {
        return userService.findByNameOrDesc(name,desc);
    }

    @RequestMapping("findByDesc")
    public List<User> findByDesc(String desc) {
        return userService.findByDesc(desc);
    }

    @RequestMapping("findById")
    public User findById(long id) {
        return userService.findById(id);
    }



}


