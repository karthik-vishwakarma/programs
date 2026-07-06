package com.kk.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class GetMinFromList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(9);
        list.add(2);

        Integer i = list.stream().min(Integer::compare).orElse(-1);
        System.out.println(i);

        //Without using min function
        Integer min = list.stream().reduce((a, b) -> a < b ? a : b).orElse(-1);
        System.out.println(min);


        Integer i1 = Stream.of(2, 4, 6, 1, 8, 9).min(Comparator.comparing(Integer::valueOf)).orElse(-1);
        System.out.println(i1);
    }
}
