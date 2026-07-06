package com.kk.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GetSecondHighestLowestNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 3, 3, 6, 8, 32, 4, 47, 83, 83);
        Integer secondHighestNumber = list.stream().distinct().sorted(Collections.reverseOrder()).skip(1).limit(1).findFirst().orElse(-1);
        System.out.println(secondHighestNumber);

        Integer secondLowestNumber = list.stream().distinct().sorted().skip(1).limit(1).findFirst().orElse(-1);
        System.out.println(secondLowestNumber);
    }
}
