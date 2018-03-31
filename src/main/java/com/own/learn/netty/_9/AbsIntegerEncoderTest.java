package com.own.learn.netty._9;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Test;

public class AbsIntegerEncoderTest {

    @Test
    public void testEncoder() {
        ByteBuf buffer = Unpooled.buffer();
        for (int i=0; i< 10; i++) {
            buffer.writeInt(i * -1);
        }

        EmbeddedChannel channel = new EmbeddedChannel(new AbsIntegerEncoder());
        channel.writeOutbound(buffer);
        channel.finish();
//        assert (channel.writeOutbound(buffer));
//        assert (channel.finish());

        for (int i=0; i< 10; i++) {
            Object o = channel.readOutbound();

            System.out.println(o);
            assert (i == (Integer)o);
        }

        assert (channel.readOutbound() == null);

    }
}
