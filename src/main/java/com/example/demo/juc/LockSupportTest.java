package com.example.demo.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/12/30 14:59
 * @Description: TODO
 */
public class LockSupportTest {


    static List<Thread> threadList = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(()->{
            LockSupport.park();
            Thread.interrupted();
            System.out.println("thread 1 执行！");
        });
        t1.start();
        threadList.add(t1);

        System.out.println("唤醒！");

        Thread thread = threadList.get(0);
        Thread.sleep(10000);
        LockSupport.unpark(thread);


    }



}
