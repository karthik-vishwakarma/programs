package com.kk.string;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SeparateStringAccordingToCount {
    public static void main(String[] args) {
        String s1 = "101010104541";
        // Output: result="544111100000";
        seprateString(s1);
        System.out.println();
        System.out.println(arrangeSequenceString(s1));
    }

    public static String arrangeSequenceString(String str) {
        StringBuilder builder = new StringBuilder();
        str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new))
                .forEach((c, count) -> {
                    while (count > 0) {
                        builder.append(c);
                        count--;
                    }
                });
        return builder.toString();
    }

    private static void seprateString(String s1) {
        List<Map.Entry<Character, Long>> entries = s1.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        for (Map.Entry<Character, Long> entry : entries) {
            Long value = entry.getValue();
            for (int i = 0; i < value; i++) {
                System.out.print(entry.getKey());
            }
        }
    }
}
