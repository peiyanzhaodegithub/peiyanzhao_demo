package com.example.demo.exception.notify;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/12/29 14:04
 * @Description: 通过logback实现异常通知
 */
@RestController
@Slf4j
public class NotifyController {

    @GetMapping("div")
    public String div(int a, int b) {
        try {
            return String.valueOf(a / b);
        } catch (Exception e) {
            log.error("div error!",e);
            return "some error!";
        }
    }

}
