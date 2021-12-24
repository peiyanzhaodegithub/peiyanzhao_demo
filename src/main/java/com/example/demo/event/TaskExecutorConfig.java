package com.example.demo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/7/8 16:20
 * @Description: TODO
 */
@Component
@Slf4j
public class TaskExecutorConfig implements AsyncConfigurer {


    private static ThreadPoolExecutor executor;

    static {
        executor = new ThreadPoolExecutor(
                2,
                2,
                100,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @Override
    public Executor getAsyncExecutor() {
        log.info("=========使用线程池处理业务！");
        return executor;
    }
}
