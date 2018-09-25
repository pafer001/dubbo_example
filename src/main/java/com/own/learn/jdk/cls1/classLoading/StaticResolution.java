package com.own.learn.jdk.cls1.classLoading;

public class StaticResolution {

    public static void sayHello() {
        System.out.println("hello world!");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }
}
