package com.own.learn.jdk.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author wangzhenya
 */
public class SemaphoreTest {

    private static final int THREAD_COUNT = 30;

    static Semaphore semaphore = new Semaphore(10);

    static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {


        for (int i=0; i< THREAD_COUNT; i++) {

            executorService.execute(new Runnable() {
                @Override
                public void run() {

                    try {

                        semaphore.tryAcquire();
                        System.out.println(" save data");
                        semaphore.release();
                    } catch (Exception e) {

                    }
                }
            });
        }

        executorService.shutdown();
    }
}
