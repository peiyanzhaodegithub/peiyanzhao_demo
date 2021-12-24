package com.example.demo.shejimoshi.guanchazhe;

import com.alibaba.fastjson.JSON;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/8/5 11:40
 * @Description: TODO
 */
public class Observer2 implements Observer{
    @Override
    public void update(MySubject mySubject) {
        System.out.println("Observer2变化"+ JSON.toJSONString(mySubject));
    }
}
