package com.own.learn.jdk.cls1.classLoading;

public class StaticDispatch {

    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human gay) {
        System.out.println("Hello, gay");
    }

    public void sayHello(Man gay) {
        System.out.println("Hello, man");
    }

    public void sayHello(Woman gay) {
        System.out.println("Hello, Woman");
    }

    public static void main(String[] args) {

        Human man = new Man();
        Human woman = new Woman();

        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHello(man);
        staticDispatch.sayHello(woman);
    }

}
