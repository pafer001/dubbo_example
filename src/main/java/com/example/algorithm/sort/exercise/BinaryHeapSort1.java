package com.example.algorithm.sort.exercise;

import com.example.algorithm.sort.BaseSort;

public class BinaryHeapSort1 extends BaseSort {

    public static void main(String[] args) {

        int[] array = {1, 7, 3, 5, 6, 0};

        new BinaryHeapSort1().sort(array);
        print(array);
    }

    public void sort(int [] array) {
        int len = array.length -1;

        for (int i=0; i < len/ 2 -1; i++) {
            sink(array, i, len);
        }

        for (int i = len -1; i>= 0; i--) {
            swap(array, i, 0);
            sink(array, 0, len);
        }
    }
    public void sink(int[] array, int i, int len) {

        int left, right;
        while (2 * i + 1 < len ) {
            left = 2* i +1;
            right = 2* i +2;

            int j = left;
            if (array[left] < array[right]) {
                j = right;
            }

            if (array[j] > array[i]) {
                swap(array, i, j);
            } else {
                break;
            }

            i= j;

        }
    }
}
