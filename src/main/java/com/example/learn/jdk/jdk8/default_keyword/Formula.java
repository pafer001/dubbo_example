package com.example.learn.jdk.jdk8.default_keyword;

/**
 * Created by pafer on 17-4-28.
 */
public interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
