package com.example.learn.jdk.cls1.classLoading;

public class DeadLoopClass {

    static {
        if (true) {
            System.out.println(Thread.currentThread() + " init DeadLoopClass");
            while (true) {
            }
        }
    }

    public static void main(String[] args) {

        final Runnable script = new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread() + " start");
                final DeadLoopClass deadLoopClass = new DeadLoopClass();
                System.out.println(Thread.currentThread() + " run over");
            }
        };

        final Thread thread = new Thread(script);
        final Thread thread1 = new Thread(script);
        thread.start();
        thread1.start();
    }
}
