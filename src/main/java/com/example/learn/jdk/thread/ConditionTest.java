package com.example.learn.jdk.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    private static volatile int condition = 0;
    private static Lock lock = new ReentrantLock();
    private static Condition lockCondition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (!(condition == 1)) {
                        lockCondition.await();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
                System.out.println("a executed by condition");
            }
        });
        A.start();
        Thread.sleep(2000);
        condition = 1;
        lock.lock();
        try {
            lockCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}
