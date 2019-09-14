package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> rets = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        for (int i =0; i < nums.length; i++) {

            for (int j = i+1; j < nums.length; j++) {

                for (int m = j + 1; m < nums.length; m++) {
                    for (int n = m +1; n < nums.length; n ++) {

                        if (nums[i] + nums[j] + nums[m] + nums[n] == target) {
                            ArrayList<Integer> objects = new ArrayList<>();
                            objects.add(nums[i]);
                            objects.add(nums[j]);
                            objects.add(nums[m]);
                            objects.add(nums[n]);

                            rets.add(objects);
                        }
                    }
                }
            }
        }
        return rets;
    }
}
