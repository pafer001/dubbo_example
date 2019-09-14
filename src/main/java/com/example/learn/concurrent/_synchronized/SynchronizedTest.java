package com.example.learn.concurrent._synchronized;

public class SynchronizedTest {

    int val = 1;

    public synchronized void add() {
        val++;
    }

    public void show() {
        System.out.println(val);
    }

    public static void main(String[] args) {

        final SynchronizedTest synchronizedTest = new SynchronizedTest();
        synchronizedTest.add();
        synchronizedTest.show();

    }

    public static class SynchronizedTest1 {

        int val = 1;

        public synchronized void add() {
            val ++;
        }

        public void show() {

    //        System.out.println(val);
        }
        public static void main(String[] args) {

            final SynchronizedTest synchronizedTest = new SynchronizedTest();
            synchronizedTest.add();
            synchronizedTest.show();

        }
    }
}
