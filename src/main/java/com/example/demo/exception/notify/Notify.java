package com.example.demo.exception.notify;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/12/29 11:51
 * @Description: 此处可以通过异步方式发送通知，只有出现ERROR日志才会触发，如果需要异常触发可以试试使用全局异常捕获，捕获异常后通过钉钉或邮箱等发送异常通知
 */
@Slf4j
public class Notify extends AppenderBase<ILoggingEvent> {

    private static final long INTERVAL = 10 * 1000 * 60;
    private long lastAlarmTime = 0;


    @Override
    protected void append(ILoggingEvent iLoggingEvent) {
        if (canAlarm()) {
            send(iLoggingEvent.getLoggerName(), iLoggingEvent.getFormattedMessage());
        }
    }

    public static void send(String title, String context) {

        log.info("发送钉钉，邮件等通知！{}，{}",title,context);
    }

    private boolean canAlarm() {
        // 做一个简单的频率过滤
        long now = System.currentTimeMillis();
        if (now - lastAlarmTime >= INTERVAL) {
            lastAlarmTime = now;
            return true;
        } else {
            return false;
        }
    }


}
