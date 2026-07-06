package com.kk.array;

public class PeakElement {
    //Find a peak element which is not smaller than its neighbours
    //Given an array arr[] of integers. Find a peak element i.e. an element that is not smaller than its neighbors.
    //
    //Note: For corner elements, we need to consider only one neighbor.
    public static void main(String[] args) {
        System.out.println("---------Test1-------");
        //Input: array[]= {5, 10, 20, 15}
        //Output: 20
        //Explanation: The element 20 has neighbors 10 and 15, both of them are less than 20.
        int[] arr = {5, 10, 20, 15};
        printPeakElements(arr, arr.length);

        System.out.println("---------Test2-------");
        //Input: array[] = {10, 20, 15, 2, 23, 90, 67}
        //Output: 20 or 90
        //Explanation: The element 20 has neighbors 10 and 15, both of them are less than 20, similarly 90 has neighbors 23 and 67.
        int[] arr1 = {10, 20, 15, 2, 23, 90, 67};
        printPeakElements(arr1, arr1.length);


        System.out.println("---------Test3-------");
        printPeakElementsUsingRecursion(arr, arr.length);

        System.out.println("---------Test4-------");
        printPeakElementsUsingRecursion(arr1, arr1.length);

    }

    //Doubt
    //2nd Approach
    //Find a peak element using recursive Binary Search
    private static void printPeakElementsUsingRecursion(int[] arr, int n) {
        System.out.println(arr[peakRecursion(arr, 0, n - 1, n)]);
    }

    private static int peakRecursion(int[] arr, int low, int high, int n) {
        int mid = low + (high - low) / 2;
        if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid])) return mid;
        else if ((mid > 0 && arr[mid - 1] > arr[mid])) return peakRecursion(arr, low, mid - 1, n);
        else return peakRecursion(arr, mid + 1, high, n);
    }


    //1st Approach
    private static void printPeakElements(int[] arr, int n) {
        if (arr[0] > arr[1]) {
            System.out.print(arr[0]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                System.out.println(arr[i]);
            }
        }
        if (arr[n - 2] < arr[n - 1]) {
            System.out.println(arr[n - 1]);
        }
    }
}
