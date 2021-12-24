package com.example.demo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/18 14:30
 * @Description: TODO
 */
@RestController
@RequestMapping("/datasource")
public class DataSourceController {


    @Autowired
    private DatasSourceService datasSourceService;

    @RequestMapping("/test")
    public String getDatasource(){

        datasSourceService.getDatasource();
        return "success";
    }


}
