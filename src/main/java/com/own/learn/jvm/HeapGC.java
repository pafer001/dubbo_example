package com.own.learn.jvm;

public class HeapGC {

    public static void main(String[] args) {

        for (int i =0; i< Integer.MAX_VALUE; i++) {
            String t = String.valueOf(i).intern();
        }
    }
}
