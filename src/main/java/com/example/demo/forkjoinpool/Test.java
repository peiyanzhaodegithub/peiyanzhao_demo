package com.example.demo.forkjoinpool;

import java.util.concurrent.ForkJoinPool;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/8/4 14:50
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        int sumBegin = 0, sumEnd = 10000000;
        computeByForkJoin(sumBegin, sumEnd);
        computeBySingleThread(sumBegin, sumEnd);
    }

    private static void computeByForkJoin(int sumBegin, int sumEnd) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(16);
        long forkJoinStartTime = System.nanoTime();
        TheKingRecursiveSumTask theKingRecursiveSumTask = new TheKingRecursiveSumTask(sumBegin, sumEnd, 100);
        long forkJoinResult = forkJoinPool.invoke(theKingRecursiveSumTask);
        System.out.println("======");
        System.out.println("ForkJoin任务拆分：" + TheKingRecursiveSumTask.getTaskCount());
        System.out.println("ForkJoin计算结果：" + forkJoinResult);
        System.out.println("ForkJoin计算耗时：" + (System.nanoTime() - forkJoinStartTime) / 1000000);
    }

    private static void computeBySingleThread(int sumBegin, int sumEnd) {
        long computeResult = 0L;
        long startTime = System.nanoTime();
        for (int i = sumBegin; i < sumEnd; i++) {
            computeResult += i;
        }
        System.out.println("======");
        System.out.println("单线程计算结果：" + computeResult);
        System.out.println("单线程计算耗时：" + (System.nanoTime() - startTime) / 1000000);
    }


}
