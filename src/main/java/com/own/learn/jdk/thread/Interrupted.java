package com.own.learn.jdk.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author wangzhenya
 */
public class Interrupted {

    public static void main(String[] args)  {

        try {
            Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
            sleepThread.setDaemon(true);

            Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
            busyThread.setDaemon(true);

            sleepThread.start();
            busyThread.start();

            TimeUnit.SECONDS.sleep(5);
            sleepThread.interrupt();
            busyThread.interrupt();

            System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
            System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());

            SleepUtils.second(2);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}


class SleepRunner implements Runnable {
    @Override
    public void run() {

        while (true) {
            SleepUtils.second(10);
        }
    }
}


class BusyRunner implements Runnable {
    @Override
    public void run() {

    }
}