package com.own.learn.jdk.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author
 */
public class ThreadSate {


    public static void main(String[] args) {

        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();

        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();

    }

    static class TimeWaiting implements Runnable {
        @Override
        public void run() {

            while (true) {
                SleepUtils.second(100);
            }
        }
    }


    static class Waiting implements Runnable {
        @Override
        public void run() {

            while (true) {

                synchronized (Waiting.class) {

                    SleepUtils.second(200);
                }
            }
        }
    }


    static class Blocked implements Runnable {

        @Override
        public void run() {

            synchronized (Blocked.class) {

                while (true) {
                    SleepUtils.second(100);
                }
            }
        }
    }
}


