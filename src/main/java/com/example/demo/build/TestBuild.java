package com.example.demo.build;

import com.alibaba.fastjson.JSON;


public class TestBuild {


    public static void main(String[] args) {
        ItemBuilder builder = new ItemConcreteBuilder();
        ItemDirector director = new ItemDirector(builder);
        Item item = director.normalConstruct();

        System.out.println(JSON.toJSONString(item));

        //剔除导演类
        ItemBuilder builder1 = new ItemConcreteBuilder();
        builder1.buildVideo();
        Item item1 = builder1.getResult();
        System.out.println(JSON.toJSONString(item1));

    }

}
