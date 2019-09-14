package com.example.learn.jdk.thread;


import java.util.concurrent.TimeUnit;

/**
 * @author wangzhenya
 */
public class Shutdown {


    public static void main(String args[]) throws Exception {

        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();

        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
        System.out.println(countThread.isInterrupted());

        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();
        System.out.println(countThread.isInterrupted());

        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }



    private static class Runner implements Runnable {

        private long i;

        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " + i);
        }


        public void  cancel() {
            on = false;
        }

    }
}
