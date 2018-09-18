package com.own.algorithm.search;

/**
 * 二分查找
 * 有序数组
 *
 * @author wangzhenya
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] array = {1, 3, 5, 6, 7, 8, 9, 90};
        final int search = new BinarySearch().search(array, 1);
        System.out.println(search);
        System.out.println(new BinarySearch().recursionSearch(array, 1, 0, array.length -1));
    }


    public int recursionSearch(int[] array, int v, int left, int right) {

        if (left > right) {
            return -1;
        }
        int mid = (left + right) /2 ;
        if (v == array[mid]) {
            return mid;
        } else if (v > array[mid]) {

            left = mid + 1;
        } else {
            right = mid - 1;
        }
        return recursionSearch(array, v, left, right);
    }

    public int search(int[] array, int v) {


        int left = 0;
        int high = array.length - 1;

        while (high >= left) {
            int mid = (left + high) / 2;

            if (v == array[mid]) {
                return mid;
            } else if (v > array[mid]) {

                left = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return -1;

    }
}
