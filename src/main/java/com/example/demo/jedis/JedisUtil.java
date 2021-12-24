package com.example.demo.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {

    private static JedisPool pool;
    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 设置最大10个连接
        jedisPoolConfig.setMaxTotal(10);
        pool = new JedisPool(jedisPoolConfig, "localhost");

    }

    public String get(String key){
        Jedis jedis = null;
        try{
            jedis = pool.getResource();
            return jedis.get(key);
        }finally{
            if(null != jedis)
                jedis.close(); // 释放资源还给连接池
        }
    }

    public String set(String key,String value){
        Jedis jedis = null;
        try{
            jedis = pool.getResource();
            return jedis.set(key, value);
        }finally{
            if(null != jedis)
                jedis.close(); // 释放资源还给连接池
        }
    }

}
