package com.own.learn.concurrent.Volatile;

public class VolatileSingleTest {

    volatile static B b = null;

    public synchronized void getB() {
        if (b == null) {

            synchronized (VolatileSingleTest.class) {
                if (null == b) {
                    b = new B();
                }
            }

        }
    }

    class B {

    }

}
