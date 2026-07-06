package com.kk.array;

import java.util.Arrays;

public class MoveNumber {
    public static void main(String[] args) {
        //Move all the negative elements to one side of the array
        //Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
        //Output: -12 -13 -5 -7 -3 -6 11 6 5
        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        int n = 9;
        int j = 0;
        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            if (temp < 0) {
                if (i != j) {
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
