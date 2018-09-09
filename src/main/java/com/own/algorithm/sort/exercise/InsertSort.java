package com.own.algorithm.sort.exercise;

import com.own.algorithm.sort.BaseSort;

/**
 * @author wangzhenya
 */
public class InsertSort extends BaseSort {

    public static void main(String[] args) {

        int[] array = {2, 3, 4, 1, 6, 9, 1, 4};

        final InsertSort insertSort = new InsertSort();
        insertSort.sort(array);
        print(array);
    }

    public void sort(int[] array) {

        if (array == null || array.length <= 1) {
            return;
        }

        for (int i = 1; i <= array.length - 1; i++) {

            for (int j = i; j > 0; j--) {

                if (array[j - 1] > array[j]) {

                    swap(array, j - 1, j);
                } else {
                    break;
                }
            }

        }

    }


}
