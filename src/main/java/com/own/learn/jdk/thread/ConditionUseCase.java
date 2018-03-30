package com.own.learn.jdk.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionUseCase {

    static Lock lock = new ReentrantLock();

    static Condition condition = lock.newCondition();

    public void conditionWait() throws InterruptedException {

        lock.lock();
        try {
            condition.await();
        } finally {
            lock.unlock();
        }
    }

    public void conditionSignal() throws InterruptedException {

        lock.lock();

        try {
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

    }
}
