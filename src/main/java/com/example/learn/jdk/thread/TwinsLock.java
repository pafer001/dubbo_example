package com.example.learn.jdk.thread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author wangzhenya
 */
public class TwinsLock {

    private final Sync sync = new Sync(2);
    class Sync extends AbstractQueuedSynchronizer {
        public Sync(int count) {
            if (count < 0) {
                throw new IllegalArgumentException("count < 0");
            }
            setState(count);
        }



        @Override
        protected int tryAcquireShared(int arg) {

            for (;;) {
                int current = getState();
                System.out.println(Thread.currentThread() + "  / " + current);
                int newCount = current - arg;
                if (newCount < 0 || compareAndSetState(current, newCount)) {
                    return newCount;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {

            for (;;) {
                int current = getState();
                int newCount =  current + arg;
                if (compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }

    }

    public void lock() {
        sync.acquireShared(1);
    }

    public void unlock() {
        sync.releaseShared(1);
    }
}
