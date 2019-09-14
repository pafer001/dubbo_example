package com.example.learn.netty._5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

public class ByteBuf12 {

    public static void main(String[] args) {

        Charset utf8 = Charset.defaultCharset();

        ByteBuf byteBuf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        System.out.println((char) byteBuf.getByte(0));
        int readerIndex = byteBuf.readerIndex();
        int writerIndex = byteBuf.writerIndex();

        byteBuf.setByte(0, (byte)'B');
        System.out.println((char) byteBuf.getByte(0));
        assert readerIndex == byteBuf.readerIndex();
        assert writerIndex == byteBuf.writerIndex();
    }
}
