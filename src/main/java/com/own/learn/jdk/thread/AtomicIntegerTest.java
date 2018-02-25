package com.own.learn.jdk.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangzhenya
 */
public class AtomicIntegerTest {

   static AtomicInteger atomicInteger =  new AtomicInteger();

    public static void main(String[] args) {

        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
    }
}
