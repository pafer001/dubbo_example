package com.example.learn.jdk.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author wangzhenya
 */
public class Priority {



    public static volatile boolean notStart = true;
    public static volatile boolean notEnd = true;


    public static void main(String[] args) throws InterruptedException {

        List<Job> jobs = new ArrayList<>();


        for (int i =0; i< 10; i++) {

            int priority = i < 5? Thread.MIN_PRIORITY: Thread.MAX_PRIORITY;

            Job job = new Job(priority, "job name " + i);
            jobs.add(job);

            Thread thread = new Thread(job, "Thread:" + i);
            thread.setPriority(priority);
            thread.start();
        }

        notStart = false;
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;

        for (Job job : jobs) {
            System.out.println(job);
        }
    }
    static class Job implements Runnable {

        private String name;
        private int priority;
        private long jobCount;

        public Job(int priority, String name) {
            this.priority = priority;
            this.name = name;
        }

        @Override
        public void run() {
            while (notStart) {
                Thread.yield();
            }

            while (notEnd) {
                Thread.yield();
                jobCount++;
            }
        }


        @Override
        public String toString() {
            return "Job{" +
                    "name='" + name + '\'' +
                    ", priority=" + priority +
                    ", jobCount=" + jobCount +
                    '}';
        }
    }
}
