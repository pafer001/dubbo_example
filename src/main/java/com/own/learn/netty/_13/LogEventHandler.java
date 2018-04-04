package com.own.learn.netty._13;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class LogEventHandler  extends SimpleChannelInboundHandler<LogEvent>{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogEvent event) throws Exception {

        StringBuilder builder = new StringBuilder();

        builder.append(event.getReceivedTimestamp());
        builder.append(" [");
        builder.append(event.getSource().toString());
        builder.append("] [");
        builder.append(event.getLogfile());
        builder.append("] : ");
        builder.append(event.getMsg());
        System.out.println(builder.toString());
    }
}
