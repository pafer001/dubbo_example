package com.example.learn.netty._9;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Test;

public class FixedLengthFrameDecoderTest {


    @Test
    public void testFramesDecoded() {

        ByteBuf buffer = Unpooled.buffer();

        for (int i=0; i< 9;i++) {
            buffer.writeByte(i);
        }

        ByteBuf input = buffer.duplicate();
        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));

        assert(channel.writeInbound(input.retain()));
        assert(channel.finish());

        ByteBuf read = (ByteBuf)channel.readInbound();
        assert(buffer.readSlice(3).equals( read));
        read.release();

        read = (ByteBuf)channel.readInbound();
        assert(buffer.readSlice(3).equals( read));
        read.release();

        read = (ByteBuf)channel.readInbound();
        assert(buffer.readSlice(3).equals( read));
        read.release();

        assert (channel.readInbound() == null);
        buffer.release();
    }


    @Test
    public void testFramesDecoded2() {

        ByteBuf buffer = Unpooled.buffer();

        for (int i=0; i< 9;i++) {
            buffer.writeByte(i);
        }

        ByteBuf input = buffer.duplicate();
        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));

        assert (channel.writeInbound(input.readBytes(2)) == false);
        assert (channel.writeInbound(input.readBytes(7)));

        assert(channel.writeInbound(input.retain()));
        assert(channel.finish());

        ByteBuf read = (ByteBuf)channel.readInbound();
        assert(buffer.readSlice(3).equals( read));
        read.release();

        read = (ByteBuf)channel.readInbound();
        assert(buffer.readSlice(3).equals( read));
        read.release();

        read = (ByteBuf)channel.readInbound();
        assert(buffer.readSlice(3).equals( read));
        read.release();

        assert (channel.readInbound() == null);
        buffer.release();
    }

}
