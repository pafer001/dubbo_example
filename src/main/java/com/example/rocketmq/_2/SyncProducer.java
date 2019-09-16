package com.example.rocketmq._2;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class SyncProducer {


    /**
     * sh mqadmin updateTopic -n localhost:9876 -b localhost:10911 -t please_rename_unique_group_name
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name1");

        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.setSendMsgTimeout(10000);
        producer.start();


        for (int i =0; i < 100 ; i++) {

            Message message = new Message("TopicTest", "TagA", ("Hello RocketMq" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(message);
            System.out.printf("%s%n", sendResult);
        }

        producer.shutdown();
    }
}
