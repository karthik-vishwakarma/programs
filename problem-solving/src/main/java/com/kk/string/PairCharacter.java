package com.kk.string;

import java.util.HashMap;

public class PairCharacter {
    public static void main(String[] args) {
        String str = "aaabccccdffexxff";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == str.charAt(i + 1)) {
                map.merge(ch, 1, Integer::sum);
                i++;
            }
        }
        System.out.println(map);
    }
}
