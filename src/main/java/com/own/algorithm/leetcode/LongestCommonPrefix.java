package com.own.algorithm.leetcode;


public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length < 1) {
            return "";
        }

        int i = 0;
        for (i =0; i < strs[0].length(); i++) {

            char ch = strs[0].charAt(i);
            for (String str : strs) {
                if (str.length() <= i || str.charAt(i) != ch) {

                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0].substring(0, i);
    }

}
