package com.kk.stream;

import java.util.*;
import java.util.stream.Collectors;

public class PrintDuplicateNumbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 6, 4, 6, 7, 33, 6, 7, 8, 9);
        Set<Integer> duplicates1 = list.stream().filter(e -> Collections.frequency(list, e) > 1).collect(Collectors.toSet());
        System.out.println(duplicates1);

        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicates2 = list.stream().filter(e -> !set.add(e)).collect(Collectors.toSet());
        System.out.println(duplicates2);
    }
}
