package com.example.demo.shejimoshi.template;

import org.springframework.stereotype.Service;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/16 10:40
 * @Description: TODO
 */
@Service
public class QingjiaService extends TemplateAbstract{
    @Override
    protected void firstGroupLeader(String name) {
        System.out.println("第一级组长审批");
    }

    @Override
    protected void secondGroupLeader(String name) {
        super.secondGroupLeader(name);

        System.out.println("第二级组长审批");

    }

    public void testQingJia(String args) {
        super.askForLeace(args);
    }




}
