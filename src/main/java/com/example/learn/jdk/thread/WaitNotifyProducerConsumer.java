package com.example.learn.jdk.thread;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * @author wangzhenya
 */
public class WaitNotifyProducerConsumer {

    private LinkedList<String> storages = new LinkedList();

    /**
     * 消费者
     */
//    public synchronized void consumer() throws InterruptedException {
//        synchronized (storages) {
//            try {
//                String first = storages.removeFirst();
//                System.out.println("----consumer----" + first);
//            } catch (NoSuchElementException e) {
//                storages.wait();
//            }
//            storages.notifyAll();
//        }
//
//    }

    public synchronized void consumer() throws InterruptedException {
            try {
                String first = storages.removeFirst();
                System.out.println("----consumer----" + first);
            } catch (NoSuchElementException e) {
                this.wait();
            }
        storages.notifyAll();

    }

    /**
     * 生产者
     */
    public synchronized  void producer() throws InterruptedException {
            if (storages.size() >= 10) {
                this.wait();
            }
            String element = String.valueOf(System.currentTimeMillis());
            storages.addLast(element);
            System.out.println("----producer----" + element + " size is" + storages.size());

        this.notifyAll();

    }

    public static void main(String[] args) {
        WaitNotifyProducerConsumer waitNotifyProducerConsumer = new WaitNotifyProducerConsumer();

        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 11; i++) {
                    try {
                        waitNotifyProducerConsumer.producer();

                    } catch (Exception e) {
                    }
                }
            }
        });
        producerThread.start();


        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    try {
                        waitNotifyProducerConsumer.consumer();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        consumerThread.start();

        try {
            Thread.sleep(100000);
        } catch (Exception e) {

        }
    }
}
