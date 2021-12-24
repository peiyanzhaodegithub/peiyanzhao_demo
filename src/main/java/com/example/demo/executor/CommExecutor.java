package com.example.demo.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class CommExecutor {

    private static final Logger logger = LoggerFactory.getLogger(CommExecutor.class);

    private final ExecutorService executor;

    public CommExecutor() {
        executor = new ThreadPoolExecutor(16, 26,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10000),
                new ThreadPoolExecutor.CallerRunsPolicy());

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
            }
        }));

    }


    public <T> Future<T> submit(Callable<T> callable) {
        return executor.submit(callable);
    }

    public void submit(ExecutorInterface i) {
        executor.submit(() -> {
            try {
                i.run();
            } catch (Exception e) {
                logger.error("", e);
            }
        });
    }

}
