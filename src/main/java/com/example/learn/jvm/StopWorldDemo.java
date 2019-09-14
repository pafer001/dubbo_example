package com.example.learn.jvm;

import java.util.HashMap;

public class StopWorldDemo {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        PrintThread printThread = new PrintThread();
        myThread.start();
        printThread.start();
    }
}


class MyThread extends Thread {

    HashMap map = new HashMap();

    @Override
    public void run() {

        try {

            while (true) {
                if (map.size() * 512 /1024/ 1024 >=  400) {
                    map.clear();
                }
                System.out.println("clean map");
                for (int i =0 ; i< 100; i++) {
                    byte[] b1 = new byte[512];
                    map.put(System.nanoTime(), b1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class PrintThread extends Thread {

    private final long starttime = System.currentTimeMillis();


    @Override
    public void run() {

        try {
            while (true) {
                long t = System.currentTimeMillis() - starttime;
                System.out.println("time" + t / 1000 + "." + t % 1000);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
