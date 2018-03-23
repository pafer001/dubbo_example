package com.own.learn.netty._4;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class NettyOioServer {

    public void server(int port) throws Exception {
        ByteBuf byteBuf = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Hi\r\n", Charset.forName("UTF-8")));
        OioEventLoopGroup group = new OioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(group).channel(OioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                               public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {

                                   channelHandlerContext.writeAndFlush(byteBuf.duplicate())
                                           .addListener(ChannelFutureListener.CLOSE);
                               }
                            });
                        }
                    });

            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            channelFuture.channel().closeFuture().sync();
        } catch (Exception  e) {
        }finally {
            group.shutdownGracefully().sync();

        }
    }
}
