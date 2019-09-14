package com.example.learn.concurrent.Volatile;

public class VolatileVisibilityTest2 {

    public volatile boolean flag = false;

    public static void main(String[] args) {

        final VolatileVisibilityTest2 volatileVisibilityTest2 = new VolatileVisibilityTest2();

        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            volatileVisibilityTest2.flag = true;
        }).start();

        new Thread(() -> {
            while (!volatileVisibilityTest2.flag) {
            }

            System.out.println("  2 " + true);
        }).start();

    }
}
