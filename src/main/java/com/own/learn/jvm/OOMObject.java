package com.own.learn.jvm;

import java.util.ArrayList;

public class OOMObject {


    static class Ele {

        public byte[] placeHolder = new byte[64 * 1024];
    }

    private static void test() {
        ArrayList<Ele> eles = new ArrayList<>();


        for (int i =1; i< 1000; i++) {
            eles.add(new Ele());
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }

        System.gc();;
        System.out.println("gc over");

    }
    public static void main(String[] args) {

        test();;


        while (true) {

        }

    }
}
