package com.example.learn.jdk.cls1.polymorphic;

public class Overload {


    public  void sayHello(Object o) {
        System.out.println(" hello object");
    }

    public  void   sayHello(int a) {
        System.out.println(" hello int ");
    }

    public  void main(String[] args) {

        new Overload().sayHello('a');
    }
}
