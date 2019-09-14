package com.example.learn.jdk.cls1.classLoading;

public class SlotTest1 {

    public static void main(String[] args) {
        {
            byte[] placeHolder = new byte[64 * 1024 * 1024];
        }

        int a = 0;

        System.gc();
    }
}
