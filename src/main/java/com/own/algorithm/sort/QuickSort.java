package com.own.algorithm.sort;

/**
 * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 */
public class QuickSort extends BaseSort {


    public static void main(String[] args) {

        int[] array = {6, 9, 1, 5, 11};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, 0, 4);
        print(array);
    }


    public int sort(int[] array, int low, int high) {

        int i = low + 1, j = high;

        int point = low;

        while (j > point) {

            if (array[j] < array[point]) {

                swap(array, point, j);
                point = j;
                j = high;
                continue;
            }
            j--;
        }

        while (i < point) {
            if (array[i] > array[point]) {
                swap(array, point, i);
                point = i;
                i = low;
                continue;
            }
            i--;
        }

        return point;
    }
}
