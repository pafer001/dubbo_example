package com.own.learn.jdk.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangzhenya
 */
public class CountDownLatchTest {

    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws Exception {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                countDownLatch.countDown();
                System.out.println(2);

                try {
                    Thread.sleep(1111);
                } catch (Exception e) {
                }
                countDownLatch.countDown();
            }
        }).start();

        countDownLatch.await();

        System.out.println("3");
    }
}
