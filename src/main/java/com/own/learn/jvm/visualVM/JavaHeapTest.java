package com.own.learn.jvm.visualVM;

import java.util.concurrent.TimeUnit;

public class JavaHeapTest {

    public final static long OUTOFMEMORY = 200000000L;

    private String oom;

    private long length;

    StringBuffer tempOOM = new StringBuffer();

    public JavaHeapTest(long leng) {
        this.length = leng;

        long i = 0;
        while (i < leng) {
            i++;
            try {
                Thread.sleep(10);
                tempOOM.append("Launches VisualVM from within IDEA. ");
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        this.oom = tempOOM.toString();

    }

    public String getOom() {
        return oom;
    }

    public long getLength() {
        return length;
    }

    public static void main(String[] args) {


        JavaHeapTest javaHeapTest = new JavaHeapTest(OUTOFMEMORY);
        System.out.println(javaHeapTest.getOom().length());

        try {

            Thread.sleep(6000000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
