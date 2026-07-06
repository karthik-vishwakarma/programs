package com.kk.stream;

import java.util.Arrays;
import java.util.List;

public class PrintSumOfAllNumbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 4, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(Integer::sum).orElse(0);
        System.out.println(sum);
    }
}
