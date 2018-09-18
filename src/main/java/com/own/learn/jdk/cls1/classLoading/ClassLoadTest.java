package com.own.learn.jdk.cls1.classLoading;

import java.io.InputStream;

public class ClassLoadTest {


    public static void main(String[] args) throws Exception {

        final ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {

                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";

                    final InputStream is = this.getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }

                    final byte[] bytes = new byte[is.available()];
                    is.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (Exception e) {

                }
                return super.loadClass(name);
            }
        };

        final Object o = classLoader.loadClass("com.own.learn.jdk.cls1.classLoading.ClassLoadTest").newInstance();
        System.out.println(o.getClass());

        System.out.println(o instanceof com.own.learn.jdk.cls1.classLoading.ClassLoadTest);
    }
}
