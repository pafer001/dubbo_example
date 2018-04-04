package com.own.learn.netty._12;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.util.SelfSignedCertificate;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class SecureChatServer extends ChatServer {

    private final SslContext context;

    public SecureChatServer(SslContext context) {
        this.context = context;
    }

    @Override
    protected ChannelInitializer<Channel> createInitializer(
            ChannelGroup group) {
        return new SecureChatServerInitializer(group, context);
    }

    @Override
    public void destory() {
        super.destory();
    }

    public static void main(String[] args)   {
        try {
            if (args.length != 1) {nn
                System.err.println("Please give port as argument");
                System.exit(1);
            }
            int port = Integer.parseInt(args[0]);
            SelfSignedCertificate cert = new SelfSignedCertificate();
            SslContext context = SslContext.newServerContext(
                    cert.certificate(), cert.privateKey());
            final SecureChatServer endpoint = new SecureChatServer(context);
            ChannelFuture future = endpoint.start(new InetSocketAddress(port));
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    endpoint.destory();
                }
            });
            future.channel().closeFuture().syncUninterruptibly();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
