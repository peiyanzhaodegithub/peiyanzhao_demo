package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/15 10:48
 * @Description: TODO
 */
public class JDKProxy implements InvocationHandler {

    private Object target;
    public JDKProxy(Object target) {
        this.target=target;
    }

    public <T> T getProxy(){
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("输出hello reflect之前");
        Object obj = method.invoke(target, args);
        System.out.println("输出hello reflect之后");
        return obj;
    }
}
