package com.kk.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortNumbers {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(2, 54, 7, 84, 21, 46, 7, 9);

        List<Integer> ascList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(ascList);

        List<Integer> descList = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(descList);
    }
}
