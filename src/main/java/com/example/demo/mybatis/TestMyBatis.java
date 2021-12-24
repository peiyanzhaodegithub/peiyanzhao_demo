package com.example.demo.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/8/2 11:18
 * @Description: TODO
 */
@Slf4j
@RestController
@RequestMapping("test")
public class TestMyBatis {

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("/mybatis")
    public String test_IUserDao() {
        BeanFactory beanFactory = applicationContext;
        IUserDao userDao = beanFactory.getBean("userDao", IUserDao.class);
        String res = userDao.queryUserInfo();
        log.info("测试结果：{}", res);
        return res;
    }



}
