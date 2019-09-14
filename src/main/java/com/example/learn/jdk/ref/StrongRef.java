package com.example.learn.jdk.ref;

/**
 * Created by pafer on 17-7-30.
 */
public class StrongRef {

    public static void collect() throws InterruptedException {
        System.out.println("开始垃圾回收...");
        System.gc();
        System.out.println("结束垃圾回收.....");
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException{

        System.out.println("创建一个强引用---->");

        Referred strong = new Referred();

        StrongRef.collect();

        System.out.println("删去引用---->");

        strong = null;
        StrongRef.collect();;
        System.out.println("done");
    }
}
