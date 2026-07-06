package com.kk.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeTwoLists {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(2, 1, 6, 7, 1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(7, 2, 5, 7, 8, 3, 2, 1, 4, 6, 7, 3, 8);
        List<Integer> collect = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        System.out.println(collect);
    }
}
