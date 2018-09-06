package com.own.learn.concurrent.Volatile;


public class VolatileVisibilityTest implements Runnable {

    volatile boolean quit = false;
    int i = 0;

    public static void main(String[] args) throws InterruptedException {

        VolatileVisibilityTest accounting = new VolatileVisibilityTest();
        Thread a1 = new Thread(accounting, "a1");
        Thread a2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("开始通知线程结束");
                    accounting.setQuit(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        a2.start();
        a1.start();
        Thread.sleep(1000);
    }

    @Override
    public void run() {
        while (!quit) {
            i++;
        }
        System.out.println("线程退出");
    }

    public boolean isQuit() {
        return quit;
    }

    public void setQuit(boolean quit) {
        this.quit = quit;
    }
}
