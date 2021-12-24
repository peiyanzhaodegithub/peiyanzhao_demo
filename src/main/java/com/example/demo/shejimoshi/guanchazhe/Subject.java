package com.example.demo.shejimoshi.guanchazhe;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/8/5 11:45
 * @Description: TODO
 */
public interface Subject {

    /**
     * 添加观察者
     * */

    public void add(Observer observer);

    /**
     * 删除观察者
     * */
    public void del(Observer observer);

    /**
     * 通知所有观察者
     * */
    public void notifyObservers(MySubject mySubject);

    /**
     * 自身操作
     * */
    public void operation(MySubject mySubject);

}
