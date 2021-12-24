package com.example.demo.shejimoshi.guanchazhe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/8/5 11:40
 * @Description: TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MySubject extends AbstractSubject {

    private String name;


    @Override
    public void operation(MySubject mySubject) {
        super.operation(mySubject);
    }
}
