package com.example.demo.queue.delayqueue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/25 10:23
 * @Description: TODO
 */
public class DelayQueueTest {


    public static void main(String[] args) throws InterruptedException {

        Item item1 = new Item("item1", 5, TimeUnit.SECONDS);
        Item item2 = new Item("item2",10, TimeUnit.SECONDS);
        Item item3 = new Item("item3",15, TimeUnit.SECONDS);

        DelayQueue<Item> queue = new DelayQueue<>();
        queue.put(item1);
        queue.put(item2);
        queue.put(item3);
        System.out.println("begin time:" + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        for (int i = 0; i < 3; i++) {
            Item take = queue.take();
            System.out.format("name:{%s}, time:{%s}\n",take.getName(), LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        }


    }







}
