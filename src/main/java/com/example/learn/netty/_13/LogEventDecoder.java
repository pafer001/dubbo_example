package com.example.learn.netty._13;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;

import java.util.List;

public class LogEventDecoder extends MessageToMessageEncoder<DatagramPacket> {

    @Override
    protected void encode(ChannelHandlerContext ctx, DatagramPacket datagramPacket, List<Object> out) throws Exception {

        ByteBuf data = datagramPacket.content();
        int idx = data.indexOf(0, data.readableBytes(), LogEvent.SEPARATOR);

        String fileName = data.slice(0, idx).toString(CharsetUtil.UTF_8);

        String logMsg = data.slice(idx + 1, data.readableBytes()).toString(CharsetUtil.UTF_8);

        LogEvent logEvent = new LogEvent(datagramPacket.sender(), fileName, logMsg, System.currentTimeMillis());

        out.add(logEvent);
    }
}
