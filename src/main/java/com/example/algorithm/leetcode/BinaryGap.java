package com.example.algorithm.leetcode;

public class BinaryGap {
//1001
    public static void main(String[] args) {

        System.out.println(new BinaryGap().binaryGap(22));
    }
    public int binaryGap(int N) {
        int count = 0;
        int lastCount = 0;
        while (N != 0) {
            int tmp = N % 2;

            if (tmp == 0 && count != 0) {
                // nothing
                count++;
            } else if (tmp == 1 && count == 0){
                count++;
            } else if (tmp == 1 && count != 0) {
                if (lastCount < count) {
                    lastCount = count;
                }
                count = 1;
            } else if (tmp == 0 && count == 0) {
                // nothing
            }

            N = N / 2;
        }
        return lastCount ;
    }
}
