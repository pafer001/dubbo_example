package com.own.algorithm.leetcode;


public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};

        int[] ints = new TwoSum().twoSum(nums, 17);
        System.out.println(ints);
    }
    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length <= 1) {
            return nums;
        }


        for (int i = 0; i < nums.length; i++) {

            for (int j= i+1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {

                    int[] array = new int[2];
                    array[0] = i;
                    array[1] = j;

                    return array;
                }

            }
        }

        return null;
    }
}
