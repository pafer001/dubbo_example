package com.own.algorithm;

/**
 * 简单选择排序是最简单直观的一种算法，基本思想为每一趟从待排序的数据元素中选择最小（或最大）的一个元素作为首元素，
 * 直到所有元素排完为止，简单选择排序是不稳定排序。
 */
public class SelectSort extends BaseSort {


    public static void main(String[] args) {

        int[] array = {11, 2, 3, 5, 1, 6, 7, 9};
        new SelectSort().sort(array);
        print(array);
    }

    public void sort(int[] array) {

        if (null == array || array.length == 0) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);

        }

    }


}
