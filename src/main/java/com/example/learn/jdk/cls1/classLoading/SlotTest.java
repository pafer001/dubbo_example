package com.example.learn.jdk.cls1.classLoading;

public class SlotTest {


    public static void main(String[] args) {

        byte[] bytes = new byte[64 * 1024 * 1024];
        System.gc();
    }
}
