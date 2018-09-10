package com.own.algorithm.sort;

/**
 * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 */
public class QuickSort extends BaseSort {


    public static void main(String[] args) {

        int[] array = {4, 6, 1, 7, 3, 9};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, 0, 4);
        print(array);
    }

    public void sort(int[] array, int low, int high) {

        if (array == null || array.length <= 1) {
            return;
        }
        if (low >= high) {
            return;
        }
        final int partition = partition(array, low, high);
        sort(array, 0, partition - 1);
        sort(array, partition + 1, high);
    }


    public int partition(int[] array, int low, int high) {


        int v = array[low];

        int i = low + 1;
        int j = high;
        while (true) {

            while (i <= high) {
                if (array[i] > v) {
                    break;
                }
                i++;
            }

            while (j >= low + 1) {
                if (array[j] < v) {
                    break;
                }
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(array, i, j);
        }

        swap(array, low, j);

        print(array);

        return j;

    }
}
