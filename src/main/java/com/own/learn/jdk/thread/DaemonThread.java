package com.own.learn.jdk.thread;

/**
 * @author wangzhenya
 */
public class DaemonThread {

    public static void main(String[] args) {

        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {

        @Override
        public void run() {
            try {
                SleepUtils.second(1000);
            } finally {
                System.out.println("Daemon Thread finally run");
            }
        }
    }
}
