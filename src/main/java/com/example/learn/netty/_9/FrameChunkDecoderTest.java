package com.example.learn.netty._9;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Assert;
import org.junit.Test;

public class FrameChunkDecoderTest {

    @Test
    public void testFramesDecoded() {

        ByteBuf buffer = Unpooled.buffer();
        for (int i=0;i<9;i++) {
            buffer.writeByte(i);
        }

        ByteBuf input = buffer.duplicate();

        EmbeddedChannel channel = new EmbeddedChannel(new FrameChunkDecoder(3));
        assert channel.writeInbound(input.readBytes(2));

        try {
            channel.writeInbound(input.readBytes(4));
            Assert.fail();
        }catch (Exception e) {

        }

        Assert.assertTrue(channel.writeInbound(input.readBytes(3)));
        assert channel.finish();

        ByteBuf read = (ByteBuf)channel.readInbound();
        ByteBuf byteBuf = buffer.readSlice(2);
        System.out.println(byteBuf);
        assert byteBuf.equals(read);
        read.release();

        read  = channel.readInbound();
        assert buffer.skipBytes(4).readSlice(3).equals(read);
        read.release();
        buffer.release();
    }
}
