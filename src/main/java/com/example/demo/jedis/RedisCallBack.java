package com.example.demo.jedis;

import redis.clients.jedis.Jedis;

@FunctionalInterface
public interface RedisCallBack<T> {

    T doInRedis(Jedis jedis);

}
