package com.kk;


@FunctionalInterface
interface IAdd {
    //Method Deceleration
    int sum(int a, int b);
}

public class Add {
    public static void main(String[] args) {

        //Method Definition
        IAdd add = (int a, int b) -> a + b;

        //Method Call
        int c = add.sum(10, 30);

        System.out.println(c);
    }
}