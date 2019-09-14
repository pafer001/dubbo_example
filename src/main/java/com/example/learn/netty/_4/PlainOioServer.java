package com.example.learn.netty._4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PlainOioServer {


    public void server(int port) throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);

        try {

            while (true) {
                Socket accept = serverSocket.accept();
                System.out.println("accepted connection from " + accept);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStream outputStream;

                        try {
                            outputStream = accept.getOutputStream();
                            outputStream.write("Hi!\r\n".getBytes());
                            outputStream.flush();
                            accept.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        } finally {
                            try {
                                accept.close();
                            }catch (Exception e) {

                            }
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        try {
            new PlainOioServer().server(9919);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
