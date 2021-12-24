package com.example.demo.netty2;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.*;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/7/2 11:36
 * @Description: TODO
 */
public class ServerChanelHandle extends SimpleChannelInboundHandler {

    //必须定义为类成员变量。每个客户端连接时，都会new ChatServerHandler。static保证数据共享
    public static ChannelGroup cg = new  DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    @Override
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        Channel channel = channelHandlerContext.channel();
        cg.forEach(i->{
            i.writeAndFlush(i.remoteAddress() + "进来了");
        });
        cg.add(channel);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        cg.forEach(i->{
            i.writeAndFlush(channel.remoteAddress() + "上线啦");
        });
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel channel = ctx.channel();
        cg.forEach(i->{
            if (channel == i){
                i.writeAndFlush("我说" + msg);
            }else {
                i.writeAndFlush(channel.remoteAddress() + "说： " + msg);
            }
        });
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        cg.remove(channel);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();

        String customerAdderss = channel.remoteAddress().toString();

        cg.forEach(i->{
            i.writeAndFlush("客户端" + customerAdderss + "下线了！");
        });

    }
}
