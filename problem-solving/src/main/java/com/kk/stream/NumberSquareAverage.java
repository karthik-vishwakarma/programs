package com.kk.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class NumberSquareAverage {
    //Square number should be grater then 100
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 4, 6, 7, 33, 21, 33);
        OptionalDouble average = list.stream().map(e -> e * e).mapToInt(e -> e).filter(e -> e > 100).average();
        System.out.println(average.isPresent() ? average.getAsDouble() : -1);
    }
}
