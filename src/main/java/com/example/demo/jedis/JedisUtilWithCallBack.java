package com.example.demo.jedis;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

@Component
public class JedisUtilWithCallBack extends JedisOperations {


    public <T> List<T> pipelined(RedisReturn<T> redisCallBack) {
        List<T> result = new ArrayList<>();
        redisCallBack.run(pool.getResource(), result);
        return result;
    }

    public String get(String key) {
        return execute(new RedisCallBack<String>() {
            @Override
            public String doInRedis(Jedis jedis) {
                return jedis.get(key);
            }
        });
    }

    public String set(String key, String value) {
        return execute(new RedisCallBack<String>() {
            @Override
            public String doInRedis(Jedis jedis) {
                return jedis.set(key, value);
            }
        });
    }
//这里可以继承JedisOperations，就能使用它的execute方法
    //也能用依赖的方式，持有JedisOperations的引用然后使用它的execute方法
    //JedisOperations jedisOperations = new JedisOperations();



}
