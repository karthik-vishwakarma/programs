package com.kk.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 *  This code filters even numbers from a list using Java Streams
 *
 * @description This code creates a list of integers and filters out the even numbers using the `filter` method of the Stream API.
 */
public class FilterEvenNumbers {
    public static void main(String[] arges){
        List<Integer> list = Arrays.asList(1,2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.printf("Even numbers from the list: %s%n", collect);
    }
}
