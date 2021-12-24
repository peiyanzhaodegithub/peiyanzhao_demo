package com.example.demo.forkjoinpool;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/8/4 14:45
 * @Description: TODO
 */
public class TheKingRecursiveSumTask extends RecursiveTask<Long> {

    private static final AtomicInteger taskCount = new AtomicInteger();
    private final int sumBegin;
    private final int sumEnd;
    private final int threshold;

    public TheKingRecursiveSumTask(int sumBegin, int sumEnd, int threshold) {
        this.sumBegin = sumBegin;
        this.sumEnd = sumEnd;
        this.threshold = threshold;
    }

    @Override
    protected Long compute() {

        if ((sumEnd - sumBegin) > threshold){
            TheKingRecursiveSumTask subTask1 = new TheKingRecursiveSumTask(sumBegin, (sumBegin+sumEnd)/2,threshold);
            TheKingRecursiveSumTask subTask2 = new TheKingRecursiveSumTask((sumBegin + sumEnd) / 2, sumEnd, threshold);
            subTask1.fork();
            subTask2.fork();
            taskCount.incrementAndGet();
            return subTask1.join() + subTask2.join();
        }
        // 直接执行结果
        long result = 0L;
        for (int i = sumBegin; i < sumEnd; i++) {
            result += i;
        }
        return result;

    }

    public static AtomicInteger getTaskCount() {
        return taskCount;
    }
}
