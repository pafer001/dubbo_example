package com.own.learn.netty._13;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import org.w3c.dom.events.Event;

import java.net.InetSocketAddress;

public class LogEventMonitor {

    private EventLoopGroup group;
    private Bootstrap bootstrap;

    public LogEventMonitor(InetSocketAddress address) {
        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();

        bootstrap.group(group)
                .channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {

                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new LogEventDecoder());
                        pipeline.addLast(new LogEventHandler());
                    }
                }).localAddress(address);
    }

    public Channel bind() {
        return bootstrap.bind().syncUninterruptibly().channel();
    }

    public void stop() {
        group.shutdownGracefully();
    }

    public static void main(String[] args) throws Exception {

        if (args.length  != 1) {
            throw new IllegalArgumentException("Usage LogEventMonitor <port>");
        }

        LogEventMonitor logEventMonitor = new LogEventMonitor(new InetSocketAddress(Integer.parseInt(args[0])));

        try {

            Channel bind = logEventMonitor.bind();
            System.out.println("LogEventMonitor running.....");
            bind.closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            logEventMonitor.stop();;
        }
    }
}
