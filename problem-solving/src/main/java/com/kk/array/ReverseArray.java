package com.kk.array;

import java.util.Arrays;

public class ReverseArray {
    //reverse an array
    public static void main(String[] args) {
        //Input  : arr[] = {1, 2, 3}.
        //Output : arr[] = {3, 2, 1}.
        int[] arr = {1, 2, 3};
        reverseArray(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));


        //Input :  arr[] = {4, 5, 1, 2}.
        //Output : arr[] = {2, 1, 5, 4}.
        int[] arr1 = {4, 5, 1, 2};
        reverseArray(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }

    private static void reverseArray(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        swap(arr, start, end);
        reverseArray(arr, ++start, --end);
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
