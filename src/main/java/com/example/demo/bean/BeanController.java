package com.example.demo.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/8/3 11:06
 * @Description: 实现spring工厂，创建对象
 */
@RestController
@RequestMapping("test")
public class BeanController {


    @Autowired
    ApplicationContext applicationContext;


    @RequestMapping("/bean")
    public String test(){

        BeanFactory beanFactory = applicationContext;
        UserBean userBean = beanFactory.getBean("testBean",UserBean.class);
        return userBean.getName();
    }

}
