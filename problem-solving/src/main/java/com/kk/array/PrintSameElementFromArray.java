package com.kk.array;

public class PrintSameElementFromArray {
    public static void main(String[] args) {
        //input:[0,1,11,345,777,22,34,764,44,9999,56,121]
        //output:[11,777,22,44,9999]
        int[] arr = {0, 1, 11, 345, 777, 22, 34, 764, 44, 9999, 56, 121};
        for (int i = 0; i < arr.length; i++) {
            int in = arr[i];
            char[] chars = String.valueOf(in).toCharArray();
            if (chars.length == 1) {
                continue;
            }
            boolean flag = true;
            char temp = chars[0];
            for (int j = 1; j < chars.length; j++) {
                if (temp != chars[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(in);
                if(arr.length-3 != i)
                    System.out.print(" ,");
            }
        }
    }
}
