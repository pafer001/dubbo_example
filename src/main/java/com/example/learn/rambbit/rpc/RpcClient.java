package com.example.learn.rambbit.rpc;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.UUID;

public class RpcClient {


    private Connection connection;

    private Channel channel;

    private String requestQueueName = "rpc_queue";

    private String replyQueueName;

    private DefaultConsumer consumer;

    public RpcClient() throws Exception {
        final ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername("sns");
        connectionFactory.setPassword("snstest");
        connectionFactory.setVirtualHost("/sns_test");
        connectionFactory.setHost("test2.sns.sohuno.com");
        connectionFactory.setPort(5672);
        connection = connectionFactory.newConnection();
        channel = connection.createChannel();

        replyQueueName = channel.queueDeclare().getQueue();


    }


    public String call(String message) throws Exception {
        final StringBuffer response = new StringBuffer();
        String corrId = UUID.randomUUID().toString();

        final AMQP.BasicProperties props = new AMQP.BasicProperties.Builder().correlationId(corrId)
                .replyTo(replyQueueName)
                .build();

        channel.basicPublish("", requestQueueName, props, message.getBytes());

        channel.basicConsume(replyQueueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelopQueueingConsumere, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {

                System.out.println("client body : " + new String(body));

                if (properties.getCorrelationId().equals(corrId)) {
                    response.append(new String(body));
                    System.out.println("inner response : " + response.toString());
                    return;
                }

            }
        });

        while (true) {
            if (!response.toString().isEmpty()) {
                return response.toString();
            }
        }
    }


    public static void main(String[] args) {

        try {
            final RpcClient rpcClient = new RpcClient();
            final String call = rpcClient.call("30");
            System.out.println("call :" + call);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
