package com.example.algorithm.leetcode;

/**
 * 704. Binary Search
 */
public class BinarySearch {

//    public static void main(String[] args) {
//
//        int nums[]
//        new BinarySearch().search()
//    }

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return  -1;
        }

        return search(nums, 0, nums.length -1, target);
    }

    public int search(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return search(nums, low, mid - 1, target);
        } else {
            return search(nums, mid + 1, high, target);
        }
    }
}
