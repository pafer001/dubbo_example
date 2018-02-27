package com.own.learn.jdk.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * @author wangzhenya
 */
public class CyclicBarrierTest3 {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {

                }
            }
        });

        thread.start();
        thread.interrupt();

        try {
            cyclicBarrier.await();
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(cyclicBarrier.isBroken());
        }
    }
}
