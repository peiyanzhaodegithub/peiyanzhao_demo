package com.example.demo.redis;

import com.example.demo.DemoApplication;
import com.example.demo.redis.cluster.Cluster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/12/28 15:44
 * @Description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class ClusterTest {

    @Autowired
    private Cluster cluster;


    @Test
    public void test(){
        cluster.testCluster();
    }
}
