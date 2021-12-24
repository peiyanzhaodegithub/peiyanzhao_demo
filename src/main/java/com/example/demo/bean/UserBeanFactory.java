package com.example.demo.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/8/2 11:02
 * @Description: TODO
 */
@Component
public class UserBeanFactory implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
       UserBean userBean = new UserBean("李四");
       return userBean;
    }

    @Override
    public Class<?> getObjectType() {
        return UserBean.class;
    }
}
