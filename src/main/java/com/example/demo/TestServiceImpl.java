package com.example.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/7/9 18:17
 * @Description: TODO
 */
public class TestServiceImpl extends TestService {
    @Override
    public void test1() {
        System.out.println("test1");
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, InterruptedException {

        Thread t = new Thread();
        t.start();
        t.join();

    }
}
