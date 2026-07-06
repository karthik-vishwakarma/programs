package com.kk.array;

public class SearchElementInOrderedArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7, 8};
        int element = 1;
        int index = searchElement(arr, element, 0, arr.length - 1);
        System.out.println(index);
    }

    private static int searchElement(int[] arr, int element, int startIndex, int lastIndex) {
        if (lastIndex < startIndex) return -1;
        int midIndex = (lastIndex + startIndex) / 2;
        if (arr[midIndex] == element) {
            return midIndex;
        } else if (arr[midIndex] < element) {
            return searchElement(arr, element, midIndex + 1, lastIndex);
        }
        return searchElement(arr, element, startIndex, midIndex - 1);
    }
}
