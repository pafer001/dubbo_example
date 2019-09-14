package com.example.learn.netty._4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class PlaiNioServer {

    private void serve(int port) throws IOException {

        ServerSocketChannel serverSocketChannel =  ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        ServerSocket socket = serverSocketChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        socket.bind(address);

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        final ByteBuffer msg = ByteBuffer.wrap("Hi\r\n".getBytes());

        while (true) {
            try {
                selector.select();
            } catch (IOException ex) {
                ex.printStackTrace();
                break;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {

                SelectionKey key = iterator.next();
                iterator.remove();

                try {
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel)key.channel();
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);

                        client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, msg.duplicate());

                        System.out.println("Accepsted connect from " + client);
                    }

                    if (key.isWritable()) {
                        SocketChannel client = (SocketChannel)key.channel();
                        ByteBuffer buffer = (ByteBuffer)key.attachment();
                        while (buffer.hasRemaining()) {

                            if (client.write(buffer) ==0) {
                                break;
                            }
                        }

                        client.close();
                    }
                } catch (Exception e) {
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }

    }
}
