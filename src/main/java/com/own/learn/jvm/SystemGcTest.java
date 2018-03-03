package com.own.learn.jvm;

public class SystemGcTest {

    public static void main(String[] args) {

        new SystemGcTest();

        System.gc();
        System.runFinalization();
    }
}
