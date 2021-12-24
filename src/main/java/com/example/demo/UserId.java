package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/22 16:07
 * @Description: TODO
 */

public class UserId {


    private List<User> list;


    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public UserId(List<User> list) {
        this.list = list;
    }

    public UserId() {
    }
}
