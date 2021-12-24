package com.example.demo.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {

    public static void main(String[] args) {
       /* AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println(atomicInteger.getAndAdd(10));
        System.out.println(atomicInteger.addAndGet(11));
*/
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("提交任务");
                    countDownLatch.countDown();
                }
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("计算分数");


    }


}
