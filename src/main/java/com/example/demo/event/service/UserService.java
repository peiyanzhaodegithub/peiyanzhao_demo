package com.example.demo.event.service;

import com.example.demo.event.UserLoginEvent;
import com.example.demo.event.UserRegisterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
public class UserService implements ApplicationEventPublisherAware {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }


    public void register(String username) {
        // ... 执行注册逻辑
        logger.info("[register][执行用户({}) 的注册逻辑]", username);

        // <2> ... 发布
        applicationEventPublisher.publishEvent(new UserRegisterEvent(this, username));

    }

    public void login(String username) {
        // ... 执行注册逻辑
        logger.info("[login][执行用户({}) 的登录逻辑]", username);

        // <2> ... 发布
        applicationEventPublisher.publishEvent(new UserLoginEvent(this, username));

    }


}
