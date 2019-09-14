package com.example.learn.netty._8;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;

import java.net.InetSocketAddress;

public class ChannelOptionTest {

    public static void main(String[] args) {

        final AttributeKey<Object> id = AttributeKey.newInstance("ID");
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new SimpleChannelInboundHandler<ByteBuf>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
                        System.out.println("received data");
                    }

                    public void channelRegistered(ChannelHandlerContext ctx) {
                        Object o = ctx.channel().attr(id).get();

                    }
                });

        bootstrap.option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);

        bootstrap.attr(id, 123456);

        ChannelFuture future = bootstrap.connect(new InetSocketAddress("www.baidu.com", 80));
        future.syncUninterruptibly();
    }
}
