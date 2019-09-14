package com.example.algorithm.sort;

/**
 * 自下向上
 */
public class MergeSort extends BaseSort {

    public static void main(String[] args) {

        int[] array = {3, 2, 6, 7, 1};
        new MergeSort().sort(array);
        print(array);
    }

    public void sort(int[] array) {

        //错误的
        int step = 1;
        while (step <= array.length / 2) {

            for (int i = 0; i <= array.length/2; i += 2 * step) {
                sort(array, i, i + step, i + step / 2);
            }
            step += 1;
        }
    }

    public void sort(int[] array, int low, int high, int mid) {
        int tmp[] = new int[array.length];

        int i = low, j = mid + 1;
        int index = i;
        while (i <= mid && j <= high) {

            if (array[i] > array[j]) {
                tmp[index] = array[j];
                j++;
                index++;
            } else {
                tmp[index] = array[i];
                i++;
                index++;
            }

        }

        while (i <= mid) {
            tmp[index] = array[i];
            index++;
            i++;
        }

        while (j <= high) {
            tmp[index] = array[j];
            index++;
            j++;
        }

        copy(tmp, array, low, high);
    }

    private void copy(int[] from, int[] to, int low, int high) {

        for (int i = low; i <= high; i++) {
            to[i] = from[i];
        }
    }
}
