package com.example.learn.jdk.thread;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author wangzhenya
 */
public class DelayQueueTest {


    public static void main(String[] args) throws InterruptedException {

        DelayQueue<Message> delayedQueue = new DelayQueue<>();

        for (int i =1; i< 11; i++) {

            Message message = new Message(i + "", System.currentTimeMillis() + i * 1000);
            delayedQueue.add(message);
        }

        while (!delayedQueue.isEmpty()) {

            Message message = delayedQueue.take();
            long delay = message.getDelay(TimeUnit.SECONDS);
            if (delay <= 0) {
                System.out.println(message);
            }
        }
    }
}

class Message implements Delayed {


    private String id;
    private long insertTime;

    public Message(String id, long insertTime) {
        this.id = id;
        this.insertTime = insertTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return this.insertTime + 60000 - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        Message that  = (Message)o;
        if (this.insertTime > that.insertTime) {
            return 1;
        } else if (this.insertTime == that.insertTime) {
            return 0;
        }
        return -1;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", insertTime=" + insertTime +
                '}';
    }
}
