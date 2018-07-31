package com.own.learn.jvm;

import java.util.ArrayList;
import java.util.List;

public class JavaHeapOutOfMemoryError {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        while (true) {
            list.add("此外，小南斯还告诫前湖人队友们，成为詹姆斯队友后，他们时刻会被置于放大镜下，这种压力他们必须能够应对。");
        }
    }
}
