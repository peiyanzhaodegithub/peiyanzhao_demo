package com.example.demo.shejimoshi.qiaojie;

import com.example.demo.shejimoshi.gongchang.Ball;
import com.example.demo.shejimoshi.gongchang.BasketBall;
import com.example.demo.shejimoshi.gongchang.Soccer;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/30 14:48
 * @Description: 桥接
 */
public class BallCut {

    private Ball ball;

    public Ball getBall(){
        return ball;
    }

    public void setBall(Ball ball){
        this.ball = ball;
    }

    public void create(){
        System.out.println(ball.create());
    }

    public static void main(String[] args) {
        BallCut ballCut = new BallCut();
        ballCut.setBall(new BasketBall());

        ballCut.create();

        ballCut.setBall(new Soccer());
        ballCut.create();

    }


}
