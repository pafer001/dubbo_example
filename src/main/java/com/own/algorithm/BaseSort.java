package com.own.algorithm;

public class BaseSort {

    public void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void print(int[] array) {

        for (int a : array) {
            System.out.print(a + "\t");
        }
    }

}
