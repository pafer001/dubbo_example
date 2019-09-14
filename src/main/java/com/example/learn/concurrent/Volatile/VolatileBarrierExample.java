package com.example.learn.concurrent.Volatile;

/**
 * java -XX:+UnlockDiagnosticVMOptions -XX:CompileCommand=print,*com.own.learn.concurrent.Volatile.com.own.learn.concurrent.VolatileBarrierExample
 */
public class VolatileBarrierExample {

    volatile Long v1 = null;

    public static void main(String[] args) {

        VolatileBarrierExample ex = new VolatileBarrierExample();
        ex.readAndWrite();
    }

    void readAndWrite() {
        v1 = 1L;
    }
}
