package com.kk.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstRepetitiveChar {

    public static void main(String[] args) {
        String inputString = "khhoo";
        Character firstRepetitiveChar = findFirstNonRepetitiveChar(inputString);
        System.out.println("First repetitive character: " + firstRepetitiveChar);
    }

    private static Character findFirstNonRepetitiveChar(String input) {
        return input.chars()           // IntStream
                .mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i)))  // convert to lowercase & then to Character object Stream
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // store in a LinkedHashMap with the count
                .entrySet().stream()                       // EntrySet stream
                .filter(entry -> entry.getValue() > 1L)   // extracts characters with a count of 1
                .map(Map.Entry::getKey)              // get the keys of EntrySet
                .findFirst().orElse(null);
    }
}
