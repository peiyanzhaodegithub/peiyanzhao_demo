package com.example.demo;

import lombok.experimental.UtilityClass;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/30 16:11
 * @Description: TODO
 */
@UtilityClass
public class ThreadLocalTest {

    private final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void setVal(String param){
        threadLocal.set(param);
    }

    public String getVal() {
        return threadLocal.get();
    }

    public void removeVal() {
        threadLocal.remove();
    }
}
