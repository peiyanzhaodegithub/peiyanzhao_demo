package com.example.demo.netty2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/7/2 14:14
 * @Description: TODO
 */
public class ClientChannelHandle extends SimpleChannelInboundHandler {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        System.out.println(o);
    }
}
