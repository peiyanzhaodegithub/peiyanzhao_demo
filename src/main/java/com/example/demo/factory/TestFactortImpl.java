package com.example.demo.factory;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/11 17:58
 * @Description: TODO
 */
@Component
public class TestFactortImpl implements TestInterface{
    @Override
    public void test() {
        System.out.println("========> test");
    }

    @Override
    public void add() {
        System.out.println("========> add");
    }
}
