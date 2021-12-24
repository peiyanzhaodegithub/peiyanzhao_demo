package com.example.demo.param.valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/15 16:21
 * @Description: TODO
 */
@RestController
@RequestMapping("/volid")
@Slf4j
public class ValidController {

    @PostMapping("/param")
    public String register(@RequestBody @Validated(Params.SaveGroup.class) Params params) {
       // log.info("======> 参数：{}",params.getName());
        return "success";
    }
}
