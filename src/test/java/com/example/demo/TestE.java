package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/7/9 18:23
 * @Description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestE extends TestService {

    @Autowired
    private com.example.demo.shilibianliang.TestShiLiBianLiang testShiLiBianLiang;

    @Override
    public void test1() {
        System.out.println("sssss");
    }

    @Test
    public void test(){
        super.test();
    }

    @Test
    public void test2(){
        testShiLiBianLiang.test();
    }

}
