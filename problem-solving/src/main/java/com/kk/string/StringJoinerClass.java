package com.kk.string;

import java.util.StringJoiner;

public class StringJoinerClass {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner(",");
        sj.add("RAHUL");
        sj.add("MAHIMA");
        sj.add("SHIVANI");
        System.out.println(sj);
    }
}
