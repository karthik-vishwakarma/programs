package com.kk.array;

import java.util.Scanner;

public class PrintArrayReverse {

    /*
    Print Array in Reverse

    Given the size and the elements of array A, print all the elements in reverse order.

    Input:
    First line of input contains, N - size of the array.
    Following N lines, each contains one integer, i{th} element of the array i.e. A[i].

    Output:
    Print all the elements of the array in reverse order, each element in a new line.

    Constraints:
    1 <= N <=100
    0 <= A[i] <= 1000
    */
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
        }

        for (int j = size - 1; j >= 0; j--) {
            System.out.println(arr[j]);
        }
    }
}