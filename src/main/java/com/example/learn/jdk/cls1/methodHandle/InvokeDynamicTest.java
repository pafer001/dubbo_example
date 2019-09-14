//package com.own.learn.jdk.cls1.methodHandle;
//
//import java.lang.invoke.*;
//
//public class InvokeDynamicTest {
//
//    public static void testMethod(String s) {
//
//        System.out.println("hello String: " + s);
//    }
//
//    public static CallSite BootStrapMethod(MethodHandles.Lookup lookup, String name, MethodType mt) throws Throwable {
//
//        return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest.class, name, mt));
//    }
//
//
//    private static MethodType MT_BootstrapMethod() {
//        return MethodType.fromMethodDescriptorString(
//                "(Ljava/lang/invoke/MethodHandles$Lookip.java;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", null)
//    }
//
//
//    private static MethodHandle MH_BootstrapMethod() throws Throwable {
//
//        return
//    }
//}
