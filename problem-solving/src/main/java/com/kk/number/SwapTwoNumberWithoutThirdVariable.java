package com.kk.number;

import java.util.Scanner;

//swap two numbers without using the third variable
public class SwapTwoNumberWithoutThirdVariable {
    public static void main(String[] args) {
        int x, y;
        System.out.println("ENTER YOU NUMBER");
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        y = scanner.nextInt();

        System.out.println("BEFORE SWAPPING :: X : " + x + " :: Y : " + y);
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("AFTER SWAPPING :: X : " + x + " :: Y : " + y);
    }
}
