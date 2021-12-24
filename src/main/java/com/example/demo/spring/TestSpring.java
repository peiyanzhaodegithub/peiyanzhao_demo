package com.example.demo.spring;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/30 11:02
 * @Description: 当实现BeanPostProcessor之后，spring会读取到该bean，在bean初始化时会循环调用所有BeanPostProcessor后置处理器方法
 */
@Component
public class TestSpring implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("====>Before===>"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("====>After===>"+beanName);
        return bean;
    }
}
