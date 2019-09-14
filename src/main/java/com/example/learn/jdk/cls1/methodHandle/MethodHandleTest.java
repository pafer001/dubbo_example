//package com.own.learn.jdk.cls1.methodHandle;
//
//import java.lang.invoke.MethodHandle;
//import java.lang.invoke.MethodType;
//
//public class MethodHandleTest {
//
//
//    static class ClassA {
//
//        public void println(String s) {
//            System.out.println(s);
//        }
//    }
//
//    public static void main(String[] args) {
//
//        final Object o = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
//
//    }
//
//    private static MethodHandle getPrintlnMH(Object reveiver) throws Exception {
//
//        final MethodType methodType = MethodType.methodType(void.class, String.class);
//        return null;
//    }
// }
