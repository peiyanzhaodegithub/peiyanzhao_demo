package com.example.demo.event.service;

import com.example.demo.event.UserRegisterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Async
    @EventListener
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        logger.info("[onApplicationEvent][给用户({}) 发送邮件]", userRegisterEvent.getUsername());
    }
}
