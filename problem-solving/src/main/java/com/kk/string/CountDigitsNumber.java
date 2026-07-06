package com.kk.string;

public class CountDigitsNumber {

    /*
     * You are given a string S of N characters a. Determine the number of digits and the number of English letters
     * First line: String S of length N
     * Output format
     * First line: Print the number of digits in S
     * Second line: Print the number of English letters in S
     * Constraints
     * 1≤ N ≤10
     * All a, characters are the standard ASCII characters
     */

    public static void main(String[] args) {
        String str = "ABCD1234EFGH57";
        long digitCount = str.chars().mapToObj(c -> (char) c).filter(Character::isDigit).count();
        long charCount = str.chars().mapToObj(c -> (char) c).filter(Character::isAlphabetic).count();
        System.out.println("Digit Count : " + digitCount + " Char Count : " + charCount);
    }
}
