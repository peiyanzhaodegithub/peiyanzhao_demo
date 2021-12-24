package com.example.demo.proxy;

import org.springframework.stereotype.Service;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/15 10:47
 * @Description: TODO
 */
@Service
public class HelloReflectImpl implements HelloReflect{
    @Override
    public void helloReflect() {
        System.out.println("hello reflect");
    }
}
