package com.own.learn.concurrent;

import java.util.ArrayList;

public class ProducerConsumer {

    static ArrayList<String> elements = new ArrayList<>();

    static int MAX_COUNT = 10;

    public synchronized void consume() {

        while (true) {
            synchronized (elements) {
                try {
                    if (elements.size() <= 0) {
                        elements.wait();
                    }

                    System.out.println(" consumer " + elements.remove(0));
                    elements.notifyAll();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public void produce(String obj) {

        while (true) {
            synchronized (elements) {
                try {
                    if (elements.size() >= MAX_COUNT) {
                        elements.wait();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String e = obj + " , " + System.currentTimeMillis();
                elements.add(e);
                elements.notifyAll();
                System.out.println("produce " +e);
            }
        }

    }

    public static void main(String[] args) {


        final ProducerConsumer producerConsumer = new ProducerConsumer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                producerConsumer.produce("");
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                producerConsumer.consume();
            }
        }).start();
    }


}
