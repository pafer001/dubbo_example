package com.own.learn.jdk.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pafer on 17-7-30.
 */
public class PhantomRef {

    public static class Referred {
        // Note! 如果这里重写了finalize方法,那么PhantomReference不会追加到ReferenceQueue中
//        @Override
//        protected void finalize() throws Throwable {
//            System.out.println("Referred对象被垃圾收集");
//        }
    }

    public static void collect() throws InterruptedException {
        System.out.println("开始垃圾收集...");
        System.gc();
        System.out.println("结束垃圾收集...");
        Thread.sleep(2000);
    }

    /**
     * 执行结果
     * 创建一个虚引用--->
     * 开始垃圾收集...
     * 结束垃圾收集...
     * 你需要清理一些东西了
     * Done
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("创建一个虚引用--->");

        ReferenceQueue dead = new ReferenceQueue();
        Map<Reference, String> cleanUpMap = new HashMap<>();

        Referred strong = new Referred();
        PhantomReference<Referred> phantom = new PhantomReference<>(strong, dead);
        cleanUpMap.put(phantom, "你需要清理一些东西了");

        strong = null;
        PhantomRef.collect();

        Reference reference = dead.poll();
        if (reference != null) {
            System.out.println(cleanUpMap.remove(reference));
        } else {
            System.out.println("reference为空");
        }
        System.out.println("Done");
    }
}
