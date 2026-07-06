package com.kk.array;

import java.util.Arrays;

public class KthSmallestElement {


    //Given an array arr[] and an integer K where K is smaller than size of array,
    // the task is to find the Kth the smallest element in the given array.
    // It is given that all array elements are distinct.

    //N = 6
    //arr[] = 7 10 4 3 20 15
    //K = 3
    //Output : 7
    //Explanation :
    //3rd smallest element in the given
    //array is 7.

    //Expected Time Complexity: O(n)
    //Expected Auxiliary Space: O(log(n))
    //Constraints:
    //1 <= N <= 105
    //1 <= arr[i] <= 105
    //1 <= K <= N

    public static void main(String[] args) {
        getKthElement1();
    }

    private static void getKthElement1() {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        Arrays.sort(arr);
        System.out.println(k + "rd smallest element is " + arr[k - 1]);
    }
}
