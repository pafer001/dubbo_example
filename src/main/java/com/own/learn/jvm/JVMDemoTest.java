package com.own.learn.jvm;

/**
 * @author wangzhenya
 */
public class JVMDemoTest {

    public static void main(String[] args) {
        System.out.println(toMemoryInfo());
    }
    public static String toMemoryInfo() {

        Runtime runtime = Runtime.getRuntime();
        int freeMemory =  byte2MB(runtime.freeMemory());
        int totalMemory = byte2MB(runtime.totalMemory());

        return freeMemory +"M/" + totalMemory +"M (free/total)";

    }
    public  static int byte2MB(long l) {
        return (int)(l / 1024 / 1024);
    }
}




