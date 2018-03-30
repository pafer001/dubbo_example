package com.own.learn.jdk;

public class Test {

    static Integer a =1;

    volatile Test sign = new Test();
    public static void main(String[] args) {

        synchronized (Test.class) {

        }

        System.out.println(8>>1);


        System.out.println((8 << 1) + 1);
    }
}
