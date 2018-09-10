package com.own.algorithm.sort.exercise;

import com.own.algorithm.sort.BaseSort;

public class QuickSort extends BaseSort {

    public static void main(String[] args) {

        int[] array = {3, 9, 4, 9, 5, 0, 6};
        final QuickSort quickSort = new QuickSort();
        quickSort.sort(array, 0, array.length -1);
        print(array);
    }

    public void sort(int[] array, int low, int high) {

        if (low >= high) {
            return;
        }
        final int partition = partition(array, low, high);
        sort(array, low, partition - 1);
        sort(array, partition + 1, high);
    }

    public int partition(int[] array, int low, int high) {


        int v = array[low];
        int i = low + 1;
        int j = high;

        while (true) {

            while (j >= i) {
                if (array[j] < v) {
                    break;
                }
                j--;
            }

            while (i <= high) {

                if (array[i] > v) {
                    break;
                }
                i++;
            }

            if (j <= i) {
                break;
            }

            swap(array, i, j);
        }

        swap(array, j, low);

        return j;
    }
}
