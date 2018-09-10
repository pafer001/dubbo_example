package com.own.algorithm.sort.exercise;


public class MergeSort1 extends MergeSort {


    public static void main(String[] args) {

        int[] array = {3,4, 1, 7,0,9};
        final MergeSort1 mergeSort1 = new MergeSort1();
        mergeSort1.sort(array, 0, array.length -1);
        print(array);
    }

    public void sort(int[] array, int low, int high) {

        if (low >= high) {
            return;
        }


        int mid = (low + high + 1) / 2;


        sort(array, low, mid-1);
        sort(array, mid, high);

        merge(array, low, mid, high);
    }


}
