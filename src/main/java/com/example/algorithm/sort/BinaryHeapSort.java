package com.example.algorithm.sort;

public class BinaryHeapSort extends BaseSort {


    public static void main(String[] args) {

        int[] array = {1, 7, 3, 5, 6, 0};

        new BinaryHeapSort().sort(array);
        print(array);
    }

    public void sort(int[] array) {

        int len = array.length - 1;
        //1.构建大顶堆 len / 2 - 1
        for (int k = len / 2 - 1; k >= 0; k--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            sink(array, k, len);
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        while (len >= 0) {
            //将堆顶元素与末尾元素进行交换
            swap(array, 0, len--);
            sink(array, 0, len);
        }
    }

    public void sink(int[] array, int i, int len) {

        int left, right, j;

        while ((left = 2 * i + 1) <= len) {

            right = left + 1;
            j = left;

            if (j < len && array[left] < array[right]) {
                j++;
            }

            if (array[i] < array[j]) {
                swap(array, i, j);
            } else {
                break;
            }

            i =j;
        }
    }
}
