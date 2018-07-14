package com.own.learn.rambbit.rpc;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author wangzhenya
 */
public class RpcServer {

    private static final String RPC_QUEUE_NAME = "rpc_queue";

    public static void main(String[] args) {
        try {
            final ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setUsername("sns");
            connectionFactory.setPassword("snstest");
            connectionFactory.setVirtualHost("/sns_test");
            connectionFactory.setHost("test2.sns.sohuno.com");
            connectionFactory.setPort(5672);
            final Connection connection = connectionFactory.newConnection();
            final Channel channel = connection.createChannel();
            channel.queueDeclare(RPC_QUEUE_NAME, false, false, false, null);
            channel.basicQos(1);
            System.out.println(" awaiting rpc requests");

            final DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                    final AMQP.BasicProperties replyBuild = new AMQP.BasicProperties().builder().correlationId(properties.getCorrelationId())
                            .build();

                    String response = "";

                    try {

                        final String message = new String(body, "UTF-8");

                        response += Integer.parseInt(message) * 10;

                    } catch (Exception e) {
                        System.out.println(e.toString());
                    } finally {

                        channel.basicPublish("", properties.getReplyTo(), replyBuild, response.getBytes("UTF-8"));

                        channel.basicAck(envelope.getDeliveryTag(), false);
                    }

                }
            };


            channel.basicConsume(RPC_QUEUE_NAME, false, defaultConsumer);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
