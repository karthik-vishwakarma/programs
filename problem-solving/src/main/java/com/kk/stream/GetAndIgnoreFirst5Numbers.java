package com.kk.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetAndIgnoreFirst5Numbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,1,6,8,3,8,9,4,10);
        List<Integer> first5 = list.stream().skip(5).limit(5).collect(Collectors.toList());
        System.out.println(first5);
    }
}
