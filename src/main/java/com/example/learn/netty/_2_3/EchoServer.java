package com.example.learn.netty._2_3;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args)throws Exception {

        if (args.length != 1) {
            System.err.println("Usafe : " + EchoServer.class.getSimpleName() + " port");
            return;
        }
        int port = Integer.parseInt(args[0]);
        new EchoServer(port).start();
    }

    private void start()throws Exception {
        EchoServerHandler echoServerHandler = new EchoServerHandler();
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        try {


            ServerBootstrap serverBootstrap = new ServerBootstrap();

            serverBootstrap.group(nioEventLoopGroup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(echoServerHandler);
                        }
                    });

            ChannelFuture sync = serverBootstrap.bind().sync();
            sync.channel().closeFuture().sync();
        } finally {
            nioEventLoopGroup.shutdownGracefully().sync();
        }

    }
}
