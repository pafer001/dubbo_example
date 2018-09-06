package com.own.algorithm.sort;

public class ShellSort extends BaseSort {

    public static void main(String[] args) {
        int[] array = {8, 7, 6, 9, 10, 1, -3, 6};
        new ShellSort().sort(array);
        print(array);
    }

    public int getH(int length) {

        int h = 1;
        while (h < length / 3) {
            h = 3 * h + 1;
        }
        return h;
    }


    public void sort(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }
        int h = getH(array.length);

        while (h >= 1) {
            sort(array, h);
            h = h / 3;
        }

    }

    public void sort(int[] array, int h) {

        for (int i = h; i < array.length; i++) {

            for (int j = i; j >= h; j -= h) {

                if (array[j - h] > array[j]) {
                    swap(array, j, j - h);
                } else {
                    break;
                }

            }
        }
    }
}
