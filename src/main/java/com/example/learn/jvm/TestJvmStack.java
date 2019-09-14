package com.example.learn.jvm;

public class TestJvmStack {

    static int count = 0;
    public static void main(String[] args) {

        try {
            test1();
        } catch (Throwable e) {
            System.out.println("stack length is " + count);
            e.printStackTrace();
        }
    }

    private static void test1() {
        count ++;
        test1();
    }
}
