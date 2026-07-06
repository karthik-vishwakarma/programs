package com.kk.array;

import java.util.Arrays;

//Segregate 0s and 1s in an array
public class Segregate0sand1s {
    public static void main(String[] args) {
        //Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
        //Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
        int[] arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        segregate0and1(arr, arr.length);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        segregate0and1(arr1, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr1));
    }


    private static void segregate0and1(int[] arr, int l, int h) {
        if (l >= h) {
            return;
        }

        if (arr[l] > arr[h]) {
            swap(arr, l, h);
            ++l;
            --h;
        } else if (arr[l] == 0 && arr[l] == arr[h]) {
            ++l;
        } else if (arr[l] == 1 && arr[l] == arr[h]) {
            --h;
        } else {
            ++l;
            --h;
        }
        segregate0and1(arr, l, h);
    }

    private static void swap(int[] arr, int l, int h) {
        int temp = arr[l];
        arr[l] = arr[h];
        arr[h] = temp;
    }

    //Time Complexity : O(2n)  ≅ O(n)
    //Auxiliary Space: O(1)
    private static void segregate0and1(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                count++;
            }
            arr[i] = 0;
        }

        for (int i = count; i < n; i++) {
            arr[i] = 1;
        }
    }
}
