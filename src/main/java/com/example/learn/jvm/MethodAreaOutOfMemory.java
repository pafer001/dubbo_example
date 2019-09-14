package com.example.learn.jvm;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MethodAreaOutOfMemory {

    public static void main(String[] args) {

        while (true) {

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(TestCase.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object arg0, Method arg1, Object[] arg2,
                                        MethodProxy arg3) throws Throwable {
                    return arg3.invokeSuper(arg0, arg2);
                }
            });

            enhancer.create();
        }
    }

    static class TestCase {

    }
}
