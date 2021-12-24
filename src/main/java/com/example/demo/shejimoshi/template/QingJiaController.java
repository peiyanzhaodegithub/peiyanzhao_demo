package com.example.demo.shejimoshi.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/16 10:43
 * @Description: TODO
 */
@RestController
@RequestMapping("/qingjia")
public class QingJiaController {

    @Autowired
    private QingjiaService qingjiaService;

    @GetMapping
    @RequestMapping("/test")
    public String qingjia() {
        qingjiaService.testQingJia("张三");
        return "success";
    }


}
