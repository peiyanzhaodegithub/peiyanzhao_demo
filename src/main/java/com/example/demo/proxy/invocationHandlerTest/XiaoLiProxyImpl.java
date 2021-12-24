package com.example.demo.proxy.invocationHandlerTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/7/6 11:34
 * @Description: TODO
 */
public class XiaoLiProxyImpl implements InvocationHandler {

    private BaseService baseService;


    public XiaoLiProxyImpl(BaseService baseService){
        this.baseService = baseService;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (Object arg : args) {
            System.out.println(arg);
        }
        method.invoke(baseService, args);
        myName();
        return null;
    }

    private void myName(){
        System.out.println("我叫小丽");
    }
}
