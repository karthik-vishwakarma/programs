package com.kk.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convert2DTo1DArrayStream {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {32, 9, 50, 7}, {12, 56}};
        //output:[1,2,3,4,32,9,50,7,12,56]
        List<Integer> arrList = Arrays.stream(arr).flatMapToInt(Arrays::stream).mapToObj(ar -> (int) ar).collect(Collectors.toList());
        System.out.println(arrList);
    }
}
