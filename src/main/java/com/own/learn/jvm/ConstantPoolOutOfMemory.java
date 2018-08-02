package com.own.learn.jvm;

import java.util.ArrayList;
import java.util.List;

public class ConstantPoolOutOfMemory {


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        int i =1;
        while (true) {
            list.add(String.valueOf(i).intern());
            i++;
        }
    }
}
