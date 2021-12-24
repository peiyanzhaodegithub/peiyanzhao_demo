package com.example.demo.proxy.invocationHandlerTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Base64;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/7/6 11:37
 * @Description: TODO 基本算法
 */
public class Test {

    public static BaseService newInstance(Class cl) {

        BaseService baseService = new XiaoMingImpl();

        InvocationHandler invocationHandler = new XiaoLiProxyImpl(baseService);
        Class c[] = {BaseService.class};

        BaseService baseService1 = (BaseService) Proxy.newProxyInstance(cl.getClassLoader(), c, invocationHandler);
        return baseService1;
    }


    public static void main(String[] args) {
        BaseService baseService = newInstance(XiaoMingImpl.class);
        baseService.myName(new String[]{"1","2"});
    }


}
