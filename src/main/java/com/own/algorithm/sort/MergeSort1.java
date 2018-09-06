package com.own.algorithm.sort;

public class MergeSort1 extends MergeSort {

    public static void main(String[] args) {

        int[] array = {5,6,7,1,2,9,8};
        final MergeSort1 mergeSort1 = new MergeSort1();
        mergeSort1.sort(array, 0, array.length -1);
        print(array);
    }

    public void sort(int[] array, int low, int high) {

        if (low >=  high) {
            return;
        }
        int mid = (low + high) / 2;

        sort(array, low, mid);
        sort(array, mid + 1, high);
        sort(array, low, high, mid);
    }

}
