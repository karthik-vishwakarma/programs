package com.kk.array;

public class Rotate90ClockWise {

    //Rotate a matrix by 90 degree in clockwise direction without using any extra space
    /*
     * Input:
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * Output:
     * 7 4 1
     * 8 5 2
     * 9 6 3
     * Input:
     * 1 2
     * 3 4
     * Output:
     * 3 1
     * 4 2
     */

    public static void main(String[] args) {
        //* 1 2 3
        //* 4 5 6
        //* 7 8 9

        // 7

        int N = 3;
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate90Clockwise(arr, N);
        printMatrix(arr, N);
    }

    private static void rotate90Clockwise(int[][] a, int N) {
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                int temp = a[i][j];
                a[i][j] = a[N - 1 - j][i];
                a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
                a[j][N - 1 - i] = temp;
            }
        }
    }

    static void printMatrix(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
