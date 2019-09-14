package com.example.learn.jdk.thread;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangzhenya
 */
public class BankWaterCyclicBarrierService implements Runnable {

    CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this);

    ExecutorService executorService = Executors.newFixedThreadPool(4);

    ConcurrentHashMap<String, Integer> countMap = new ConcurrentHashMap<>();

    public void count() {


        for (int i =0; i<4; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        countMap.put(Thread.currentThread().getName(), new Date().getDate());
                        cyclicBarrier.await();
                    } catch (Exception e) {
                    }
                }
            });
        }

    }

    @Override
    public void run() {

        int count = 0;
        for (Integer integer : countMap.values()) {
            count += integer;
        }

        System.out.println(count);
    }


    public static void main(String[] args) {

        new BankWaterCyclicBarrierService().count();
    }
}
