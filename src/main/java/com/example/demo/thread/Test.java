package com.example.demo.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {


    public static Object lockObject = new Object(); //拿来做临时锁对象
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new MyThread();
        thread.start();
        Thread.sleep(1000);

        System.out.println("主线程试图占用lockObject锁资源");
        synchronized (Test.lockObject) {
            // 用Test.lockObject做一些事
            System.out.println("做一些事");
        }
        System.out.println("恢复");

        synchronized (Test.lockObject) {
            Test.lockObject.notify();
        }

    }
}

class MyThread extends Thread {
    public void run() {
        try {
            synchronized (Test.lockObject) {
                System.out.println("占用Test.lockObject");
                Test.lockObject.wait();
            }
            System.out.println("MyThread释放TestlockObject锁资源");
        }
        catch (Exception e){}
    }

}
