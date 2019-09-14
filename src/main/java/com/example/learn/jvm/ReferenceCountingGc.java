package com.example.learn.jvm;

/**
 * -Xmx10m -Xms10m -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
 */
public class ReferenceCountingGc {

    public Object instance = null;


    public static final int _1MB = 1024 * 1024;

    //这个属性 占用内存
    private byte[] bigSize = new byte[2 *_1MB];


    public static void testGC() {

        ReferenceCountingGc objA = new ReferenceCountingGc();
        ReferenceCountingGc objB = new ReferenceCountingGc();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();;
    }


    public static void main(String[] args) {

        testGC();
    }

}


