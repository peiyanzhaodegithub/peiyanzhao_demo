package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

public class UserLoginEvent extends ApplicationEvent {

    /**
     * 用户名
     */
    private String username;

    public UserLoginEvent(Object source) {
        super(source);
    }

    public UserLoginEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
