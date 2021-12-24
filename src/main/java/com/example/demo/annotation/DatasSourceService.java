package com.example.demo.annotation;

import org.springframework.stereotype.Service;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/18 14:32
 * @Description: TODO
 */
@Service
public class DatasSourceService {

    @DS(DataSourceTypeEnum.DB2)
    public String getDatasource(){

        return "success";

    }


}
