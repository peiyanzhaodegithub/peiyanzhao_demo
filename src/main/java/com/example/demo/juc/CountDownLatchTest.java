package com.example.demo.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/12/30 15:57
 * @Description: TODO
 */
public class CountDownLatchTest {

    static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 1 执行" + (i + 1) + "次！");
                countDownLatch.countDown();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {

                System.out.println("thread2 等待！");
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("thread2 执行！");
        });

        thread.start();
        thread2.start();

    }


}
