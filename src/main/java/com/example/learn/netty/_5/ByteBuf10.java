package com.example.learn.netty._5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

public class ByteBuf10 {

    public static void main(String[] args) {

        Charset utf8 = Charset.defaultCharset();

        ByteBuf byteBuf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        ByteBuf slice = byteBuf.slice(0, 15);
        System.out.println(slice.toString(utf8));

        byteBuf.setByte(0, (byte)'J');

        assert byteBuf.getByte(0) == slice.getByte(0);
    }
}
