package com.example.demo.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


public class JedisOperations {

    public static JedisPool pool;
    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);
        pool = new JedisPool(jedisPoolConfig, "localhost");

    }

    <T> T execute(RedisCallBack<T> callback) {
        Jedis jedis = null;
        try{
            jedis = pool.getResource();
            return callback.doInRedis(jedis);
        }finally{
            if(null != jedis)
                jedis.close();
        }
    }

}
