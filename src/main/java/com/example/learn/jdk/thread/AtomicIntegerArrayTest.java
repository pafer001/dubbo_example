package com.example.learn.jdk.thread;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author wangzhenya
 */
public class AtomicIntegerArrayTest {

    static int[] value = {1, 2};
    static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(value);

    public static void main(String[] args) {

        atomicIntegerArray.getAndSet(0,3);
        System.out.println(atomicIntegerArray.get(0));

        System.out.println(value[0]);

    }
}
