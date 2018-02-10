package com.own.learn.jdk.thread;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

/**
 * @author wangzhenya
 */
public class TwinsLock {

    private final Sync sync = new Sync(2);
    class Sync extends AbstractQueuedLongSynchronizer {
        public Sync(int count) {
            if (count < 0) {
                throw new IllegalArgumentException("count < 0");
            }
            setState(count);
        }

        @Override
        protected long tryAcquireShared(long arg) {

            for (;;) {
                long current = getState();
                System.out.println(Thread.currentThread() + "  / " + current);
                long newCount = current - arg;
                if (newCount < 0 || compareAndSetState(current, newCount)) {
                    return newCount;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(long arg) {

            for (;;) {
                long current = getState();
                long newCount =  current + arg;
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
