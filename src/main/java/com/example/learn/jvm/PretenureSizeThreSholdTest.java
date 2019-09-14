package com.example.learn.jvm;

public class PretenureSizeThreSholdTest {

    static int _1MB = 1024 * 1024;
    public static void main(String[] args) {

        byte[] allocation = new byte[4 * _1MB];
    }
}
