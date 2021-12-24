package com.example.demo.netty2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/7/2 11:23
 * @Description: TODO
 */
public class ChatServer {

    public void openServer(int port){
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup work = new NioEventLoopGroup(5);
        serverBootstrap.group(boss,work);
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast("encoder",new StringEncoder());
                socketChannel.pipeline().addLast("decoder",new StringDecoder());
                socketChannel.pipeline().addLast(new ServerChanelHandle());

            }
        });

        serverBootstrap.channel(NioServerSocketChannel.class);

        try {
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            System.out.println("服务端已启动，绑定端口：" + port);
            channelFuture.channel().closeFuture().sync();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.openServer(8080);
    }



}
