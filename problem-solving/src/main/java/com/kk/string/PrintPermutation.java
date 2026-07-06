package com.kk.string;

public class PrintPermutation {
    public static void main(String[] args) {
        String str = "abc";
        printPermutation(str, "");
    }

    static void printPermutation(String str, String ans) {
        if (str.isEmpty()) {
            System.out.println(ans);
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            printPermutation(ros, ans + ch);
        }
    }
}
