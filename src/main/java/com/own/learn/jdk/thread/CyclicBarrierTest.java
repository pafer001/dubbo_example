package com.own.learn.jdk.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * @author wangzhenya
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();

                } catch (Exception e) {

                }
                System.out.println(1);
            }
        }).start();

        try {
            cyclicBarrier.await();
        }catch (Exception e) {

        }

        System.out.println(2);
    }
}
