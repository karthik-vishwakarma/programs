package com.kk.stream;

import java.util.Arrays;
import java.util.List;

public class AverageOfAllNumbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 4, 6, 3, 6, 8, 3, 89, 23);
        double asDouble = list.stream().mapToInt(e -> e).average().getAsDouble();
        System.out.println(asDouble);
    }
}
