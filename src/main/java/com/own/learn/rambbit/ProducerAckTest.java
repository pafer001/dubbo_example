package com.own.learn.rambbit;


import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerAckTest {

    public static void main(String[] args) {

        try {

            final ExecutorService executorService = Executors.newFixedThreadPool(20);
            final ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setUsername("sns");
            connectionFactory.setPassword("snstest");
            connectionFactory.setVirtualHost("/sns_test");
            connectionFactory.setHost("test2.sns.sohuno.com");
            connectionFactory.setPort(5672);
            connectionFactory.setRequestedHeartbeat(1);
            connectionFactory.setAutomaticRecoveryEnabled(true);
            final Connection connection = connectionFactory.newConnection();

            final Channel channel = connection.createChannel();
            channel.exchangeDeclare("test", "direct");
            while (true) {
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            channel.basicPublish("test", "test", new AMQP.BasicProperties(),
                                    String.valueOf(System.currentTimeMillis())    .getBytes());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
