package com.example.demo.shejimoshi.daili;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/30 10:16
 * @Description: TODO
 */
@RestController
@RequestMapping("/daili")
public class DaiLiController {

    @Autowired
    private PeopleProxy peopleProxy;

    @RequestMapping("/test")
    public String test(){
        Buy buy = peopleProxy;
        buy.buyCar();
        peopleProxy.buyCar();
        return "success";
    }


}
