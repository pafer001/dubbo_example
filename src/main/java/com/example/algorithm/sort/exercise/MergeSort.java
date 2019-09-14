package com.example.algorithm.sort.exercise;

import com.example.algorithm.sort.BaseSort;

public class MergeSort extends BaseSort {


    public static void main(String[] args) {

        int[] array = {3, 2, 6, 7, 1};
        final MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array);
        print(array);
    }

    public void sort(int[] array) {

        int step = 1;

        while (step <= array.length) {

            for (int i = 0; i <= array.length; i +=  2 * step) {

                int mid = i + step;
                int high = Integer.min(array.length -1, i + 2 * step -1);

                if (mid > array.length -1) {
                    break;
                }
                merge(array, i, mid, high);
            }

            step = 2 * step;
        }


    }

    public void merge(int[] array, int low, int mid, int high) {

        int[] tmpArray = new int[array.length];

        int i = low;
        int j = mid;


        int index = low;
        while (i < mid && j <= high) {

            if (array[i] > array[j]) {
                tmpArray[index++] = array[j++];
            } else {
                tmpArray[index++] = array[i++];
            }
        }

        while (i < mid) {
            tmpArray[index++] = array[i++];
        }

        while (j <= high) {
            tmpArray[index++] = array[j++];
        }

        copy(tmpArray, array, low, high);

    }

    public void copy(int[] from, int[] to, int low, int high) {

        for (int i = low; i <= high; i++) {
            to[i] = from[i];
        }
    }


}
