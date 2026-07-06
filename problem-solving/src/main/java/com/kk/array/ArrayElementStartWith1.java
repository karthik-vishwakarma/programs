package com.kk.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayElementStartWith1 {
    public static void main(String[] args) {
        int[] arr = {1, 21, 3, 14, 61, 5, 7, 11};
        List<Integer> collect = Arrays.stream(arr).mapToObj(a -> (int) a).filter(a -> String.valueOf(a).startsWith("1")).collect(Collectors.toList());
        System.out.println(collect);
    }
}
