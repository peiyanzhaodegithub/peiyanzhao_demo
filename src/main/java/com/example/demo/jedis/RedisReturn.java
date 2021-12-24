package com.example.demo.jedis;

import redis.clients.jedis.Jedis;

import java.util.List;

@FunctionalInterface
public interface RedisReturn<T> {

    void run(Jedis commands, List<T> futures);

}
