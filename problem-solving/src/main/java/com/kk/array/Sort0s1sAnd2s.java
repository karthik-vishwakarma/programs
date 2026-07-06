package com.kk.array;

import java.util.Arrays;

//Sort an array of 0s, 1s and 2s | Dutch National Flag problem
public class Sort0s1sAnd2s {
    public static void main(String[] args) {
        //Input: {0, 1, 2, 0, 1, 2}
        //Output: {0, 0, 1, 1, 2, 2}
        int[] arr = {0, 1, 2, 0, 1, 2};
        short1(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        //
        //Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
        //Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
    }

    private static void short1(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = low + (high - low) / 2;

        if (arr[mid] > arr[high]) {
            swap(arr, mid, high);
        }

        if (arr[low] > arr[mid]) {
            swap(arr, low, mid);
        }
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }

        short1(arr, ++low, --high);
    }

    private static void swap(int[] arr, int l, int h) {
        int temp = arr[l];
        arr[l] = arr[h];
        arr[h] = temp;
    }
}
