package com.example.learn.jdk.cls1.classLoading;

public class ConstClass {

    static {
        System.out.println("  Const class init !");
    }

    public static final String HELLOWORLD = "hello world";
}
