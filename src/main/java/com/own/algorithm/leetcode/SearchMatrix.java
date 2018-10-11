package com.own.algorithm.leetcode;

/**
 * 74. Search a 2D Matrix
 */
public class SearchMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        System.out.println(new SearchMatrix().searchMatrix(matrix, 5));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int high = matrix.length;
        int middle = matrix[0].length;

        for (int i = high - 1; i >= 0; ) {

            for (int j = 0; j < middle; ) {
                int tmpValue = matrix[i][j];
                if (tmpValue > target) {
                    i--;
                    if (i == -1) {
                        return false;
                    }
                } else if (tmpValue < target) {
                    j++;
                    if (j == middle) {
                        return false;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
