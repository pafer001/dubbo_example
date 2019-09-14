package com.example.learn.generic;

public class StaticGenericMethod<T> {

// error
//    public static void out(T t) {
//
//    }

    public static <T>  void out(T t) {

        System.out.println(t);
    }


    public static void main(String[] args) {

        StaticGenericMethod.out("a");
    }
}
