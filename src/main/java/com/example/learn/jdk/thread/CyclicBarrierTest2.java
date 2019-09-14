package com.example.learn.jdk.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * @author wangzhenya
 */
public class CyclicBarrierTest2 {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new A());


    public static void main(String[] args) {
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

 class A implements Runnable {
    @Override
    public void run() {
        System.out.println(3);
    }
}
