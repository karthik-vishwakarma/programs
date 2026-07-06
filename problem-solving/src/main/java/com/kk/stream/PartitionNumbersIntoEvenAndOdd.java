package com.kk.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionNumbersIntoEvenAndOdd {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        Map<Boolean, List<Integer>> collect = nums.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even numbers: " + collect.get(true));
        System.out.println("Odd numbers: " + collect.get(false));
    }
}
