package com.own.algorithm.leetcode;

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("a"));
    }
    public String longestPalindrome(String s) {

        char[] array = s.toCharArray();

        String palindrome = "";
        for (int i =0; i < array.length; i++) {

            char firstCh = array[i];
            boolean equal = false;
            int last = i;
            for (int j = array.length -1; j >= i; j--) {
                char secCh =  array[j];
                if (firstCh == secCh) {
                    last = j;
                    equal = true;
                }

                if (equal && firstCh != secCh) {
                    equal =false;
                    continue;
                }

            }

            if (equal) {
                String tmp = s.substring(firstCh, last);
                if (tmp.length() > palindrome.length()) {
                    palindrome =  tmp;
                }
            }
        }

        return palindrome;
    }
}
