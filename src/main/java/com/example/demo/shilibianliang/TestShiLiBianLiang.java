package com.example.demo.shilibianliang;

import com.example.demo.executor.CommExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/9/26 11:29
 * @Description: TODO
 */
@Service
public class TestShiLiBianLiang extends TestAbstract {

    @Autowired
    private CommExecutor executor;


    public void test(){
        for (int i = 0; i < 10000; i++){
            int finalI = i;
            executor.submit(()->{
                super.get(finalI);
            });
        }


    }

    public static void main(String[] args) {
        TestShiLiBianLiang testShiLiBianLiang = new TestShiLiBianLiang();
        testShiLiBianLiang.test2(1);
    }

    public void test2(int a){
        test1(a);
        System.out.println(a);
    }

    private void test1(int a){
        if (a == 1){
            a = 2;
        }
        System.out.println();
    }

}
