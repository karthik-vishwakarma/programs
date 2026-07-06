package com.kk.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetDistinctCharacters {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "stream");
        List<Character> list = words.stream().map(s -> s.chars().mapToObj(c -> (char) c))
                .flatMap(c -> c).distinct().collect(Collectors.toList());
        System.out.println(list);
    }
}
