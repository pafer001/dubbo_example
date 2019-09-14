package com.example.learn.jdk.thread;

/**
 * @author pafer
 */
public class InterruptTest {


    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int i = 0;

            try {
                while (i < 1000) {
                    Thread.sleep(500);
                    System.out.println(i++);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };


    public static void main(String[] args) {

        InterruptTest interruptTest = new InterruptTest();
        Thread thread = new Thread(interruptTest.runnable);
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}
