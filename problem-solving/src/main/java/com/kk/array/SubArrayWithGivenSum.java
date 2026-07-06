package com.kk.array;

import java.util.ArrayList;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        System.out.println(subArraySum(arr, 5, 12));
    }

    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subArraySum(int[] arr, int n, int s) {
        boolean flag = false;
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int temp = s - arr[i];
            for (int j = i + 1; j < n; j++) {
                if (temp == arr[j]) {
                    end = j + 1;
                    flag = true;
                    break;
                }
                temp = temp - arr[j];
            }
            if (flag) {
                start = i + 1;
                break;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(start);
        arrayList.add(end);
        return arrayList;
    }
}
