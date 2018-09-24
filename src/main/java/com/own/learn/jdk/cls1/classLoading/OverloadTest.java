package com.own.learn.jdk.cls1.classLoading;

public class OverloadTest {

    public static void sayHello(Object arg) {
        System.out.println("hello object");
    }

    public static void sayHello(int arg) {
        System.out.println("hello int");
    }

    public static void sayHello(char arg) {
        System.out.println("hello char");
    }

    public static void main(String[] args) {
        sayHello('a');
    }
}
