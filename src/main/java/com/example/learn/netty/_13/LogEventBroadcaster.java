package com.example.learn.netty._13;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;

public class LogEventBroadcaster {

    private EventLoopGroup group;
    private Bootstrap bootstrap;
    private File file;

    public LogEventBroadcaster(InetSocketAddress address, File file) {
        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new LogEventEncoder(address));

        this.file = file;
    }


    public void run() throws Exception {
        Channel channel = bootstrap.bind(0).sync().channel();
        long pointer =0;

        while (true) {
            String absolutePath = file.getAbsolutePath();

            long length = file.length();
            if (length < pointer) {
                pointer = length;
            } else if (length > pointer){

                RandomAccessFile file = new RandomAccessFile(this.file, "r");
                file.seek(pointer);

                String line;

                while ((line = file.readLine()) != null) {
                    channel.writeAndFlush(new LogEvent(null, absolutePath, line, -1));
                }

                pointer = file.getFilePointer();
                file.close();
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                Thread.interrupted();
                break;
            }
        }
    }


    public void stop() {
        group.shutdownGracefully();
    }


    public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            throw new IllegalArgumentException();
        }

        InetSocketAddress socketAddress = new InetSocketAddress("255.255.255.255", Integer.parseInt(args[0]));

        LogEventBroadcaster logEventBroadcaster = new LogEventBroadcaster(socketAddress, new File(args[1]));
        try {
            logEventBroadcaster.run();
        } finally {
            logEventBroadcaster.stop();
        }
    }
}
