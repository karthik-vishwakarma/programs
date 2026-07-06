package com.kk.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConcatListToString {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        System.out.println(list.stream().collect(Collectors.joining(",")));

        System.out.println(String.join(",", list));
    }
}
