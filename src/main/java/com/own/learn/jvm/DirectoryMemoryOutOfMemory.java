package com.own.learn.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class DirectoryMemoryOutOfMemory {


    static int ONE_MB = 1024 * 1024;
    static int index = 0 ;
    public static void main(String[] args) {

        try {

            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe unsafe = (Unsafe)field.get(null);

            while (true) {
                index ++;
                unsafe.allocateMemory(ONE_MB);
            }
        } catch (Exception e) {
            System.out.println("index  : " + index);
            e.printStackTrace();
        } catch (Error e) {
            System.out.println("index  : " + index);
            e.printStackTrace();
        }
    }

}
