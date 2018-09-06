package com.own.algorithm;

public class InsertSort1 extends BaseSort {


    public static void main(String[] args) {

        int[] array = {5, 6, 7, -9,1, 4, 9, 0};
        final InsertSort1 insertSort1 = new InsertSort1();
        insertSort1.sort(array);

        print(array);
    }

    public void sort(int[] array) {

        for (int i = 1; i <= array.length - 1; i++) {

            for (int j = i; j >= 1; j--) {

                if (array[j] < array[j - 1]) {

                    swap(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
