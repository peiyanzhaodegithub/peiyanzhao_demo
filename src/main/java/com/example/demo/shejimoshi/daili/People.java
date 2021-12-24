package com.example.demo.shejimoshi.daili;

import org.springframework.stereotype.Service;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/30 10:08
 * @Description: TODO
 */
@Service
public class People implements Buy {
    @Override
    public void buyCar() {
        System.out.println("you get a car !");
    }
}
