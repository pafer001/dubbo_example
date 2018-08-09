package com.own.learn.jdk.ref;

import java.lang.ref.WeakReference;

/**
 * Created by pafer on 17-7-30.
 */
public class WeakRef {

    public static void collect() throws InterruptedException {
        System.out.println("开始垃圾收集...");
        System.gc();
        System.out.println("结束垃圾收集...");
        Thread.sleep(2000);
    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("创建一个弱引用--->");

        Referred strong = new Referred();
        WeakReference<Referred> weak = new WeakReference<>(strong);

        WeakRef.collect();
        System.out.println("删除引用--->");

        strong = null;
        WeakRef.collect();

        System.out.println("Done");
    }
}
