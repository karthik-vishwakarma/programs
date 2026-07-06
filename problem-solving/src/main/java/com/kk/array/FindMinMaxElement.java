package com.kk.array;

import java.util.Date;

public class FindMinMaxElement {
    public static void main(String[] args) {
        int arr[] = {1, 423, 6, 46, 34, 23, 13, 53, 4};
        System.out.println("-------Test 1-----");
        Date date = new Date();
        System.out.println("min " + getMin(arr, arr.length));
        System.out.println("max " + getMax(arr, arr.length));
        System.out.println("Test 1 Time " + (new Date().getTime() - date.getTime()) + "ms");
        Date date1 = new Date();
        System.out.println("-------Test 2-----");
        System.out.println("min " + getMin(arr, 0, arr.length));
        System.out.println("max " + getMax(arr, 0, arr.length));
        System.out.println("Test 2 Time " + (new Date().getTime() - date1.getTime()) + "ms");
    }

    //Time Complexity: O(n)
    //Auxiliary Space: O(1), as no extra space is used
    private static int getMax(int[] arr, int n) {
        int res = arr[0];
        for (int i = 1; i < n; i++) {
            res = Math.max(res, arr[i]);
        }
        return res;
    }

    private static int getMin(int[] arr, int n) {
        int res = arr[0];
        for (int i = 1; i < n; i++) {
            res = Math.min(res, arr[i]);
        }
        return res;
    }

    //Time Complexity: O(n)
    //Auxiliary Space: O(n), as implicit stack is used due to recursion
    private static int getMax(int[] arr, int i, int n) {
        return n == 1 ? arr[i] : Math.max(arr[i], getMax(arr, i + 1, n - 1));
    }

    private static int getMin(int[] arr, int i, int n) {
        return n == 1 ? arr[i] : Math.min(arr[i], getMin(arr, i + 1, n - 1));
    }
}
