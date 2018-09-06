package com.own.algorithm.sort;

/**
 * 没有调试通过
 */
public class QuickSort {

    public static void main(String[] args) {
        int array[] = {1,51,7,20};
        new QuickSort().quickSort(0, array.length -1, array);
        System.out.println(array);
    }

    public void quickSort(int left, int right, int array[]) {

        if (left >= right || left < 0 && right < 0) {
            return;
        }
        int index = left;
        int sortValue = array[index];

        int i = right;
        int j = left;

        while (i > j) {

            while (i >= left) {

                if (array[i] < sortValue) {

                    int tmpValue = array[i];

                    array[i] = sortValue;
                    sortValue = tmpValue;
                    index = i;
                    break;
                }
                i--;
            }

            while (j <= right) {

                if (sortValue > array[j]) {
                    int tmpValue = array[j];
                    array[j] = sortValue;
                    sortValue = tmpValue;
                    index = j;
                    break;
                }

                j++;
            }

            i = right;
            j = left;
        }

        array[index] = sortValue;

        quickSort(left, index -1, array);
        quickSort(index + 1, right, array);

    }
}
