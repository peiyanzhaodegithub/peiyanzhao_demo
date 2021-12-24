package com.example.demo.event.service;

import com.example.demo.event.UserLoginEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/7/8 15:03
 * @Description: TODO
 */
@Service
@Slf4j
public class LoginService {


    @Async//异步执行需要在启动类添加@EnableAsync注解
    @EventListener
    public void login(UserLoginEvent userLoginEvent) throws InterruptedException {
        Thread.sleep(10000);
        log.info(userLoginEvent.getUsername()+"登录了！");
    }


}
