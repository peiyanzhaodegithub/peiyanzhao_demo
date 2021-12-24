package com.example.demo.shejimoshi.daili;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/30 10:09
 * @Description: TODO
 */
@Service
public class PeopleProxy implements Buy{

    @Autowired
    private People people;

    @Override
    public void buyCar() {
        System.out.println("4s店给你上保险~！");
        people.buyCar();
    }

   /* public static void main(String[] args) {
        Buy buy = new PeopleProxy(new People());
        buy.buyCar();
    }*/


}
