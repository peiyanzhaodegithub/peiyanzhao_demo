package com.example.demo.mybatis;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/8/2 11:02
 * @Description: TODO
 */
@Component
public class ProxyBeanFactory implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        System.out.println("ProxyBeanFactory");

        Class[] classes = {IUserDao.class};

        InvocationHandler invocationHandler = (proxy, method, args)-> "你被代理了";

        return Proxy.newProxyInstance(classLoader, classes, invocationHandler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }


}
