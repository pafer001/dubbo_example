package com.example.learn.rambbit;


import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CosumerAckTest {

    public static void main(String[] args) {

        try {
            final ExecutorService executorService = Executors.newFixedThreadPool(20);

            final ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setUsername("sns");
            connectionFactory.setPassword("snstest");
            connectionFactory.setVirtualHost("/sns_test");
            connectionFactory.setHost("test2.sns.sohuno.com");
            connectionFactory.setPort(5672);

            final Connection connection = connectionFactory.newConnection();

                    try {
                        final Channel channel = connection.createChannel();
                        channel.queueBind("test1", "test", "test");
                        channel.basicQos(5);
                        channel.basicConsume("test1", true, new DefaultConsumer(channel) {
                            @Override
                            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {


                                try {
                                    final String msg = new String(body);
                                    System.out.println(msg);
//                                    channel.basicAck(envelope.getDeliveryTag(), false);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }catch (Exception e) {

                    }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
