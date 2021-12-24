package com.example.demo.redis;

import com.example.demo.DemoApplication;
import com.example.demo.jedis.JedisOperations;
import com.example.demo.jedis.JedisUtilWithCallBack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class RedisTestShiLiBianLiangDTO {

    @Autowired
    private JedisUtilWithCallBack jedisUtilWithCallBack;


    @Test
    public void testRedis(){
        Jedis jedis = JedisOperations.pool.getResource();
        Transaction transaction = jedis.multi();
        transaction.set("name","lisi");
        transaction.set("age","19");
        transaction.exec();

    }



}
