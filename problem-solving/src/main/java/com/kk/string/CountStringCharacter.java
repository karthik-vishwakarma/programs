package com.kk.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountStringCharacter {
    public static void main(String[] args) {
        String str = "Engineer";

        Map<Character, Long> collect = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

        //Maintain sequence
        LinkedHashMap<Character, Long> collect1 = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(collect1);
    }
}
