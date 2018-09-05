package com.own.learn.jdk.concurrent;

import java.util.concurrent.*;

public class RejectedExecutionHandlerTest {

    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
            3,
            10,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(100),
            new ConsumerRejectedExecutionHandler());

    public static void main(String[] args) {

        while (true) {
            threadPoolExecutor.execute( new RejectedExecutionRunner(System.currentTimeMillis()));
        }


    }

    static class RejectedExecutionRunner implements Runnable {

        long time;

        public RejectedExecutionRunner(long time) {
            this.time = time;
        }

        @Override
        public void run() {
            try {
                System.out.println(" ---------- " + time);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class ConsumerRejectedExecutionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            RejectedExecutionRunner runner = (RejectedExecutionRunner)r;
            System.out.println(" rejectedExecution " + runner.time);
        }
    }
}
