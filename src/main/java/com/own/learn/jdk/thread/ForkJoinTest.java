package com.own.learn.jdk.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author wangzhenya
 */
public class ForkJoinTest extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;

    private int start;
    private int end;

    public ForkJoinTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        int sum = 0;

        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i<= end; i++) {
                sum += i;
            }
        } else {

            int middle = ( end + start) /2;

            ForkJoinTest leftTask = new ForkJoinTest(start, middle);
            ForkJoinTest rightTask = new ForkJoinTest(middle + 1, end);

            leftTask.fork();
            rightTask.fork();

            Integer leftResult = leftTask.join();
            Integer rightResult = rightTask.join();

            sum = leftResult + rightResult;
        }

        System.out.println("start : " + start +" , end : " + end + ", sum : ");
        return sum;
    }


    public static void main(String[] args)  throws Exception {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTest forkJoinTest = new ForkJoinTest(1, 10);

        ForkJoinTask<Integer> submit = forkJoinPool.submit(forkJoinTest);
        System.out.println(submit.get());
    }
}
