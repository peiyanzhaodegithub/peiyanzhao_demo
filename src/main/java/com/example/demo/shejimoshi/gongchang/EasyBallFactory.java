package com.example.demo.shejimoshi.gongchang;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/30 14:40
 * @Description: 简单工厂
 */
public class EasyBallFactory {

    public static Ball createBall(String name){
        if (name.equals("basketball")){
            return new BasketBall();
        }else if (name.equals("soccer")){
            return new Soccer();
        }
        return null;
    }

    public static void main(String[] args) {
        Ball ball = EasyBallFactory.createBall("basketball");

        System.out.println(ball.create());

        Ball ball1 = EasyBallFactory.createBall("soccer");

        System.out.println(ball1.create());
    }



}
