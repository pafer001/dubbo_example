package com.own.algorithm.sort;

public class BaseSort {

    /**
     * i坐标的值小于j坐标的值
     * @param array
     * @param i
     * @param j
     * @return
     */
    public boolean less(int[] array, int i, int j) {
        return array[i] < array[j];
    }

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
        System.out.println("\n");
    }

}
