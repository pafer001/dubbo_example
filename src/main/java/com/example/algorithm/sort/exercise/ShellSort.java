package com.example.algorithm.sort.exercise;

import com.example.algorithm.sort.BaseSort;

public class ShellSort extends BaseSort {

    public int getH(int length) {

        int h = 0;
        while (h <= length / 3) {
            h = 3 * h + 1;
        }
        return h;
    }

    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int h = getH(array.length);

        while (h >= 1) {
            System.out.println(" ----- " + h);

            sort(array, h);
            h = h / 3;
        }
    }

    public static void main(String[] args) {

        int[] array = {3, 5, 2, 1, 91, 10};

        final ShellSort shellSort = new ShellSort();
        shellSort.sort(array);
        print(array);
    }

    public void sort(int[] array, int h) {


        for (int i = 1; i < array.length; i++) {

            for (int j = i; j >= h; j -= h) {

                if (array[j - h] > array[j]) {
                    swap(array, j - h, j);
                } else {
                    break;
                }
            }
        }
    }
}
