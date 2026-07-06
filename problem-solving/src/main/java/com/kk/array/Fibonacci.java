package com.kk.array;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci {

    //Every number after the first two is the sum of the two preceding.
    //Result : 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
    public static void main(String[] args) {


        //{0,1}
        //{1,1}
        //{1,2}
        //{2,3}
        //{3,5}
        //{5,8}
        //{8,13}
        //{13,21}
        //{21,34}
        //{34,55}

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(10).forEach(x -> System.out.println("{" + x[0] + "," + x[1] + "}"));

        //0
        //1
        //1
        //2
        //3
        //5
        //8
        //13
        //21
        //34
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(10).map(t -> t[0]).forEach(System.out::println);

        //Sum all the Fibonacci numbers
        int sum = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(10).map(t -> t[0]).mapToInt(Integer::intValue).sum();
        System.out.println("Total " + sum);

        //Join with commas
        //Join with commas
        String collect = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(10).map(t -> t[0]).map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(collect);
    }
}
