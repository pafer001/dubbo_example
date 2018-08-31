package com.own.learn.generic;

public class GenericMethod2<T> {

    public <T> void  out(T ... args) {

        for (T t : args) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        new GenericMethod2<>().out("A", 1, 1999L,0.3);
    }
}
