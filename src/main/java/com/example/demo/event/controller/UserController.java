package com.example.demo.event.controller;

import com.example.demo.event.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(String username) {
        userService.register(username);
        return "success";
    }

    @GetMapping("/login")
    public String login(String username) {
        userService.login(username);
        return "success";
    }




}
