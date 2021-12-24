package com.example.demo.netty2;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/7/2 14:06
 * @Description: TODO
 */
public class ChatClient1 implements Runnable{

    private String serverIP;
    private int port;

    public ChatClient1(String serverIP, int port) {
        this.serverIP = serverIP;
        this.port = port;
    }

    @Override
    public void run() {
        Bootstrap bootstrap = new Bootstrap();
        EventLoopGroup work = new NioEventLoopGroup();
        bootstrap.group(work);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast("encode", new StringEncoder());
                socketChannel.pipeline().addLast("decode", new StringDecoder());
                socketChannel.pipeline().addLast(new ClientChannelHandle());
            }
        });
        bootstrap.channel(NioSocketChannel.class);

        ChannelFuture channelFuture = bootstrap.connect(serverIP, port);
        Channel channel = channelFuture.channel();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String sendMsg = scanner.nextLine();
            channel.writeAndFlush(sendMsg);
        }
    }

    public static void main(String[] args) {
        new Thread(new ChatClient1("127.0.0.1",8080)).start();
    }
}
