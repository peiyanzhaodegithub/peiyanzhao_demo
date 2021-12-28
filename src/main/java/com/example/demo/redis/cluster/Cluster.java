package com.example.demo.redis.cluster;

import com.example.demo.jedis.JedisUtil;
import com.example.demo.jedis.JedisUtilWithCallBack;
import com.google.common.primitives.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/12/28 15:31
 * @Description: TODO
 */
@Service
public class Cluster {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void testCluster() {

        Map<String, String> keys = new HashMap<>();
        keys.put("30", "1");
        keys.put("31", "1");
        keys.put("32", "1");
        keys.put("34", "1");

        Boolean b = redisTemplate.opsForValue().multiSetIfAbsent(keys);
        System.out.println(b);
    }


}
