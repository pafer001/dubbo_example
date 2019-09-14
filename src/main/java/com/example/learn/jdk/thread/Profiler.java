package com.example.learn.jdk.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author wangzhenya
 */
public class Profiler {

    //get init
    static ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception{
        Profiler.begin();
        TimeUnit.SECONDS.sleep(10);
        System.out.println("Cost :" + Profiler.end() +" mills");
    }
}
