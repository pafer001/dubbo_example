package com.own.learn.jdk.ref;

/**
 * Created by pafer on 17-7-30.
 */
public class Referred {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Referred对象被垃圾收集");
    }
}
