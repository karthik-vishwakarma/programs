package com.kk.stream;

import java.util.Arrays;
import java.util.Comparator;

public class FindLongestString {
    public static void main(String[] args) {
        var strings = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        String s = strings.stream().max(Comparator.comparing(String::length)).orElse("");
        System.out.println(s);
    }
}
