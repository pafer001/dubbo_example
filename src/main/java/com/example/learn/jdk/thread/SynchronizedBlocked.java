package com.example.learn.jdk.thread;

public class SynchronizedBlocked {


    static Integer sigal = 1;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (sigal) {

                    try {
//                        Thread.sleep(1000000);
                        sigal.wait();
                    } catch (Exception e) {
                    }
                }
            }
        }, "thread-1").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (sigal) {

                    try {
                        System.out.println("111");
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                }
            }
        }, "thread-2").start();


    }
}
