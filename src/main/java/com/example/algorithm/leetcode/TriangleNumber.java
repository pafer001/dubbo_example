package com.example.algorithm.leetcode;

public class TriangleNumber {

    public int triangleNumber(int[] nums) {

        if (nums == null || nums.length < 3) {
            return 0;
        }

        int count  = 0;
        for (int i =0; i < nums.length; i++){
            for (int j =i+1; j < nums.length; j++){

                for (int m = j+1; m < nums.length; m++) {
                    if (isTriangle(nums[i], nums[j], nums[m])) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public boolean isTriangle(int a, int b, int c) {

        if (a + b > c && a + c > b && b + c > a) {

            if (getAbsoluteValue(a - b) < c &&
                    getAbsoluteValue(a - c) < b && getAbsoluteValue(b - c) < a) {
                return true;
            }
        }
        return false;
    }

    public int getAbsoluteValue(int v) {

        if (v < 0) {
            return  -v;
        }

        return v;
    }



}
