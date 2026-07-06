package com.kk.stream;

import java.util.Arrays;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        int kthSmallestElement = Arrays.stream(arr).sorted().skip((long) k - 1).findFirst().orElse(-1);
        System.out.println(k + "rd smallest element is " + kthSmallestElement);
    }
}
