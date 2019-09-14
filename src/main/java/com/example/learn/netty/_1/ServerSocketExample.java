package com.example.learn.netty._1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wangzhenya
 */
public class ServerSocketExample {


    public static void main(String[] args) {

        try {
            int portNumer = 8080;
            ServerSocket serverSocket = new ServerSocket(portNumer);
            Socket clientSocket = serverSocket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String request, response;

            while ((request = in.readLine()) != null) {
                if ("Done".equals(request)) {
                    break;
                }
                response = request;

                out.println(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
