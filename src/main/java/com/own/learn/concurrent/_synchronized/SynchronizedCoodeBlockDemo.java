package com.own.learn.concurrent._synchronized;

public class SynchronizedCoodeBlockDemo {

    static Integer flag = new Integer(0);
    public int i;

    public void syncTask() {

        synchronized (flag) {
            i++;
        }
    }
}
