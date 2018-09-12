package com.own.learn.concurrent;

public class SleepTest {

    public static void main(String[] args) {

        try {
            Sleep1.class.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    class Sleep1{

    }
}
