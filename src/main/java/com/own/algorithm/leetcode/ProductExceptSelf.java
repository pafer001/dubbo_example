package com.own.algorithm.leetcode;

/**
 * 238. Product of Array Except Self
 */
public class ProductExceptSelf {

        public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        int[] ints = new ProductExceptSelf().productExceptSelf(nums);
        System.out.println(ints);
    }
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }

}
