package com.example.learn.jdk.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wangzhenya
 */
public class ReentrantReadWriteLockCache {

    private static Map<String, Object> map = new HashMap<>();

    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static Lock readLock = readWriteLock.readLock();

    static Lock writeLock = readWriteLock.readLock();


    public static Object get(String key) {

        readLock.lock();

        try {

            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public static void put(String key, Object value) {

        writeLock.lock();
        try {
            map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public static void clear() {

        writeLock.lock();
        try {
            map.clear();
        } finally {
            writeLock.unlock();
        }
    }



}
