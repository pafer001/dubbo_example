package com.example.learn.jvm;

public class JvmTestGc {


    public static void test1() {

        byte[] bytes = new byte[6 * 1024 * 1024];
        System.gc();
        System.out.println("first explict gc over");
    }

    public static void main(String[] args) {
        JvmTestGc.test1();
    }

}
