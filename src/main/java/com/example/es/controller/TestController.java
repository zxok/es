package com.example.es.controller;


import com.example.es.entity.TestBean;
import com.example.es.service.TestService;
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
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("findAll")
    public Iterable<TestBean> findAll() {
        return testService.findAll();
    }

    /**
     *  添加模拟数据
     */
    @RequestMapping("list")
    public String save() {
        List<TestBean> list = null;
        testService.save(list);
        return "success";
    }

    /**
     * 添加
     * @param bean
     */
    @RequestMapping("save")
    public String save(TestBean bean) {
        testService.save(bean);
        return "OK";
    }

    @RequestMapping("findByName")
    public List<TestBean> findByName(String name) {
        return testService.findByName(name);
    }

    @RequestMapping("findByNameOrDesc")
    public List<TestBean> findByNameOrDesc(String name,String desc) {
        return testService.findByNameOrDesc(name,desc);
    }

    @RequestMapping("findByDesc")
    public List<TestBean> findByDesc(String desc) {
        return testService.findByDesc(desc);
    }

    @RequestMapping("findById")
    public TestBean findById(long id) {
        return testService.findById(id);
    }

}


