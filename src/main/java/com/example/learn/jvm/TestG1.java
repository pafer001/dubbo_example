package com.example.learn.jvm;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TestG1 {

    public static void main(String[] args) {

        while (true) {
            createMap();
        }
    }

    private static void createMap() {

        Map<String, Object> map = new HashMap<>();

        for (int i=0; i< 1000; i++) {
            map.put(String.valueOf(i), UUID.randomUUID());
        }
    }
}
