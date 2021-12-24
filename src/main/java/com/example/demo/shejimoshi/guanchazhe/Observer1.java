package com.example.demo.shejimoshi.guanchazhe;

import com.alibaba.fastjson.JSON;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/8/5 11:40
 * @Description: TODO
 */
public class Observer1 implements Observer{
    @Override
    public void update(MySubject subject) {
        System.out.println("Observer1变化"+ JSON.toJSONString(subject));
    }
}
