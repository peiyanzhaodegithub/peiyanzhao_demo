package com.example.demo.cache;

import com.google.common.cache.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Cache {

    public static com.google.common.cache.Cache<String, String> caches = CacheBuilder.newBuilder().
            maximumSize(128)//设置容量上限
            .removalListener(new RemovalListener<String, String>() {
                //移除监听器
                @Override
                public void onRemoval(RemovalNotification<String, String> notification) {
                    System.out.println(notification.getKey());
                }

            }).build();


    public static String get(final String key) throws Exception{

        String rr = caches.get(key, new Callable<String>() {

            @Override
            public String call() throws Exception {
                if ("1".equalsIgnoreCase(key)) {
                    return "test";
                }
                throw new Exception("This is a test!");
            }
        });
        return rr;
    }

    public static void main(String[] args) throws Exception {
      /*  System.out.println(Cache.get("1"));
        System.out.println("before expire: " + Cache.caches.asMap().keySet());
        Thread.sleep(5000);
        System.out.println("after expire: " + Cache.caches.asMap().keySet());*/

    }




}
