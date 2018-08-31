package com.own.learn.generic;

import java.util.ArrayList;

public class GenericTest1 {

    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Double> doubles = new ArrayList<>();

        System.out.println(strings.getClass().equals(doubles.getClass()));
    }
}
