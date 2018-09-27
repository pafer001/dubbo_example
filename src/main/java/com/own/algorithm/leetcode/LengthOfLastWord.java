package com.own.algorithm.leetcode;

public class LengthOfLastWord {

    public static void main(String[] args) {

        System.out.println(new LengthOfLastWord().lengthOfLastWord("World "));
    }
    public int lengthOfLastWord(String s) {

        final char[] sArray = s.toCharArray();

        int count = 0;
        for (int i = sArray.length -1;i >= 0 ;i--) {

            if (sArray[i] != ' ') {
                count++;
            } else if (count == 0) {

            } else {
                return count;
            }

        }
        return count;
    }

}
