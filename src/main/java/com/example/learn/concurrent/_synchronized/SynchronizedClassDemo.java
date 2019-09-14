package com.example.learn.concurrent._synchronized;

public class SynchronizedClassDemo {

    public  void method(long a) {
        System.out.println(" enter method " + a);
        synchronized(SynchronizedClassDemo.class) {

            try {
                System.out.println(" acquire lock " + a);

                System.out.println(a + " method ");
                Thread.sleep(a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(" exit method " + a);

    }

    public static void main(String[] args) {


        try {
            final Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    new SynchronizedClassDemo().method(10000);
                }
            });

            final Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {

                    new SynchronizedClassDemo().method(0);
                }
            });


            thread.start();;
            thread1.start();

            thread.join();
            thread1.join();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
