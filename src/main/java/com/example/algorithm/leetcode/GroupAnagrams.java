package com.example.algorithm.leetcode;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = getKey(str);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public String getKey(String str) {
        char[] array = str.toCharArray();
        List<String> objects = new ArrayList<>();

        for (char ch : array) {
            objects.add(String.valueOf(ch));
        }
        Collections.sort(objects);

        String key = "";
        for (String s: objects
             ) {
            key+=s;
        }
        return key;
    }
}
