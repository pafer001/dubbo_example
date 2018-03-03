package com.own.learn.jvm;

public class TestJvmStack1 {

    static int count = 0;

    static void test1(int a, int b, int c) {
        long d, e, f = 0;
        count++;
        test1(a, b, c);
    }

    public static void main(String[] args) {

        try {
            test1(0, 0, 0);

        } catch (Throwable e) {
            System.out.println(count);
            e.printStackTrace();
        }
    }
}
