package com.own.algorithm.sort;

/**
 * 每一步将一个待排序的记录
 * 插入到前面已经排好序的有序序列中去
 * 直到插完所有元素为止。
 */
public class InsertSort extends BaseSort {

    public static void main(String[] args) {

        int[] array = {5, 7, 1, 8};

        new InsertSort().sort1(array);
        print(array);
    }

    public void sort1(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 1; i < array.length - 1; i++) {

            for (int j = i; j >= 0; j--) {
                if (array[j] > array[j + 1]) {
                    swap(array, j + 1, j);
                } else {
                    break;
                }
            }
        }
    }

    public void sort(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 1; i <= array.length - 1; i++) {
            int sortValue = array[i];

            for (int j = i - 1; j >= 0; j--) {

                if (array[j] > sortValue) {
                    array[j + 1] = array[j];
                } else {
                    if (j != i - 1) {
                        array[j] = sortValue;
                    }
                    break;
                }

                if (j == 0) {
                    array[j] = sortValue;
                }

            }

        }


    }
}
