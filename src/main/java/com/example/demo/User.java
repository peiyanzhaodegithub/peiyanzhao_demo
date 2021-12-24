package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/22 16:31
 * @Description: TODO
 */

public class User{

    private String user_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public User(String user_id) {
        this.user_id = user_id;
    }

    private User() {
    }

    public void sayHello() {
        System.out.println("欢迎来到王者荣耀:"+user_id);
    }

}

