package com.example.demo.shejimoshi.template;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/16 10:34
 * @Description: 模板模式（请假例子）
 */
public abstract class TemplateAbstract {

    //第一组长审批
    protected abstract void firstGroupLeader(String name);

    //第二组长审批
    protected void secondGroupLeader(String name){};

    //告知HR
    private final void notifyHr(String name){
        System.out.println("请假人："+name);
    }

    public void askForLeace(String name){
        firstGroupLeader(name);
        secondGroupLeader(name);
        notifyHr(name);
    }


}
