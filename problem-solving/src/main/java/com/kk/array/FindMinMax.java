package com.kk.array;

import java.util.Arrays;

public class FindMinMax {
    //Maximum and minimum of an array using minimum number of comparisons
    public static void main(String[] args) {
        printMinMax1();
        printMinMax2();
    }

    private static void printMinMax1() {
        //Input: arr[] = {3, 5, 4, 1, 9}
        //Output: Minimum element is: 1
        // Maximum element is: 9
        int[] arr = {3, 5, 4, 1, 9};
        Arrays.sort(arr);
        System.out.println("MIN : " + arr[0] + " MAX : " + arr[arr.length - 1]);
    }

    private static void printMinMax2() {
        //Input: arr[] = {22, 14, 8, 17, 35, 3}
        //Output:  Minimum element is: 3
        // Maximum element is: 35
        int[] arr1 = {22, 14, 8, 17, 35, 3};
        int min = arr1[0];
        int max = arr1[0];
        for (int i = 1; i < arr1.length - 1; i++) {
            if (arr1[i] < min) {
                min = arr1[i];
            } else if (arr1[i] > max) {
                max = arr1[i];
            }
        }
        System.out.println("MIN : " + min + " MAX : " + max);
    }
}
