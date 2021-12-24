package com.example.demo.shejimoshi.guanchazhe;

import java.util.Vector;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/8/5 11:43
 * @Description: TODO
 */
public abstract class AbstractSubject implements Subject {

    private Vector<Observer> vector = new Vector<>();

    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers(MySubject mySubject) {
        vector.forEach(i->{
            i.update(mySubject);
        });
    }

    @Override
    public void operation(MySubject mySubject) {

        notifyObservers(mySubject);

    }
}
