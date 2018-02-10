package com.own.learn.jdk.thread;

/**
 * @author wangzhenya
 */
public class TwinsLockTest {
    static TwinsLock twinsLock = new TwinsLock();


    public static void main(String[] args) {


        class Work extends Thread {
            @Override
            public void run() {

                while (true) {

                    twinsLock.lock();
                    try {

                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        twinsLock.unlock();
                    }
                }

            }
        }


        for (int i=0; i< 10; i++) {
            Work work = new Work();
            work.setDaemon(true);
            work.start();
        }

        for (int i=0; i< 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }
}
