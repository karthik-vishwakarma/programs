package com.kk.array;

import java.util.Arrays;

public class SumOfOddSquareElement {
    public static void main(String[] args) {
        int[] arr = {1, 21, 3, 14, 61, 5, 7, 11};
        Integer reduce = Arrays.stream(arr) //Convent into stream
                .mapToObj(a -> (int) a) //Cast into int
                .filter(a -> a % 2 == 1) // filter odd numbers
                .map(a -> a * a) // Square the number
                .reduce(0, Integer::sum);   // Sum
        System.out.println(reduce);
    }
}
