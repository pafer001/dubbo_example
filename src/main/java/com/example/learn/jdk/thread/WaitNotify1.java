package com.example.learn.jdk.thread;

public class WaitNotify1 {


    public Integer value = new Integer(0);
    public void add () throws InterruptedException {

        synchronized (value) {
            if (value != 0) {
                value.wait();
            }
        }
    }

    public void get() throws InterruptedException  {
        synchronized (value) {

            if (value == 0) {
                value.wait();
            }
        }
    }

    public static void main(String[] args) {

        WaitNotify1 waitNotify1 = new WaitNotify1();


    }
}
