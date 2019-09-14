package com.example.algorithm.leetcode;

public class ReverseNum {

    public static void main(String[] args) {
        System.out.println(new ReverseNum().reverse(Integer.MAX_VALUE));
    }

    public int reverse(int x) {

        int tmp = 0;
        while (x != 0) {

            int pop = x % 10;
            if (tmp > Integer.MAX_VALUE / 10 || (tmp == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (tmp < Integer.MIN_VALUE / 10 || (tmp == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            tmp *= 10;
            tmp += pop;

            x /= 10;
        }
        if (x < 0) {
            tmp *= -1;
        }

        return tmp;
    }
}
