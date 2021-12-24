package com.example.demo.shejimoshi.guanchazhe;

import org.springframework.batch.item.mail.SimpleMailMessageItemWriter;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/8/5 11:50
 * @Description: TODO
 */
public class Test {

    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());

        sub.operation(new MySubject("张三"));
    }

}
