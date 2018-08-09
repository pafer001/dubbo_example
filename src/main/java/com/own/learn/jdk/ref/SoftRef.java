package com.own.learn.jdk.ref;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pafer on 17-7-30.
 */
public class SoftRef {

    public static void collect() throws InterruptedException {
        System.out.println("开始垃圾收集...");
        System.gc();
        System.out.println("结束垃圾收集...");
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("创建一个软引用--->");

        Referred strong = new Referred();
        SoftReference<Referred> soft = new SoftReference<Referred>(strong);

        SoftRef.collect();

        System.out.println("删除引用--->");

        strong = null;
        SoftRef.collect();

        System.out.println("开始堆占用");

        try {
            List<SoftRef> heap = new ArrayList<>(100);
            while (true) {
                heap.add(new SoftRef());
            }
        } catch (OutOfMemoryError e) {
            // 软引用对象应该在这个之前被收集
            System.out.println("内存溢出...");
        }

        System.out.println("Done");
    }
}
