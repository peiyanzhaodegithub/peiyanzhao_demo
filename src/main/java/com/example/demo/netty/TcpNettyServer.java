package com.example.demo.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/7/1 15:50
 * @Description: TODO
 */
public class TcpNettyServer {
    static EventLoopGroup bossLoopGroup;
    static EventLoopGroup workLoopGroup;
    static ServerBootstrap server;
    static {
        bossLoopGroup = new NioEventLoopGroup();
        workLoopGroup = new NioEventLoopGroup();
        server = new ServerBootstrap();
        server.group(bossLoopGroup,workLoopGroup);
        server.channel(NioServerSocketChannel.class);
        server.option(ChannelOption.SO_BACKLOG,128);
        server.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
        server.option(ChannelOption.SO_KEEPALIVE,true);
        //注意服务端这里一定要用childHandler 不能用handler 否则会报错
        server.childHandler(new TcpServerInitalizer());

    }

    public static void run(int port){
        try {
            ChannelFuture future = server.bind(new InetSocketAddress(port)).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossLoopGroup.shutdownGracefully();
            workLoopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        run(8080);
    }
}
