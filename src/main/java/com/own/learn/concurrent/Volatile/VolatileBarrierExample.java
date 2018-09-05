package com.own.learn.concurrent.Volatile;

/**
 * java -XX:+UnlockDiagnosticVMOptions -XX:CompileCommand=print,*com.own.learn.concurrent.VolatileBarrierExample.readAndWrite com.own.learn.concurrent.Volatile.com.own.learn.concurrent.VolatileBarrierExample
 */
public class VolatileBarrierExample {

    volatile long v1 = 1;

    public static void main(String[] args) {

        VolatileBarrierExample ex = new VolatileBarrierExample();
        ex.readAndWrite();
    }

    void readAndWrite() {

        v1 = v1 + 1;
    }
}
