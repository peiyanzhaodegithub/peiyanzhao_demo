package com.example.demo.proxy.invocationHandlerTest;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/7/6 11:33
 * @Description: TODO
 */
public class XiaoMingImpl implements BaseService{
    @Override
    public void myName(String[] strings) {
        System.out.println("我叫小明");
    }

    @Override
    public void myAge() {
        System.out.println("我18了");
    }
}
