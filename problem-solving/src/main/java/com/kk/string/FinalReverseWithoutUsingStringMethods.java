package com.kk.string;

//reverse a string without using String inbuilt function
public class FinalReverseWithoutUsingStringMethods {
    public static void main(String[] args) {
        String str = "Automation";
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        System.out.println(sb);
    }
}
