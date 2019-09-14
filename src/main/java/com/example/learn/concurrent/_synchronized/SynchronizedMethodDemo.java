package com.example.learn.concurrent._synchronized;

public class SynchronizedMethodDemo {


    public int i;

    public synchronized void syncTask() {
        i++;
    }
}
