package com.example.algorithm.leetcode;

/**
 * leetcode 27. Remove Element
 *
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i=0, j=0;
        while ( j< nums.length && i < nums.length) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                j++;
                i++;
            }else {
                j++;
            }
        }
        return i;
    }

    public static void main(String[] args) {

        int[] nums ={1,3,4,5,6,3,4};

        int len = new RemoveElement().removeElement(nums, 3);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
