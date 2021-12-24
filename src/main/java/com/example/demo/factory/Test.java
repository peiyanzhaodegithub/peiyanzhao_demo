package com.example.demo.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/11 17:58
 * @Description: TODO
 */
@Component
public class Test {

    private final Map<Integer, TestInterface> taskMap;


    @Autowired
    public Test(TestFactortImpl testFactort,TestFactort1Impl testFactort1) {
        taskMap = new HashMap<Integer,TestInterface>(){
            {
                put(1,testFactort);
                put(2,testFactort1);
            }

        };
    }

    @PostConstruct
    public void test(){

        TestInterface testInterface = taskMap.get(1);
        testInterface.test();
        System.out.println("==========>");
    }

}
