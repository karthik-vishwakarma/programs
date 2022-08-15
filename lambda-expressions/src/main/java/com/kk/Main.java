package com.kk;

public class Main {
    public static void main(String[] args) {

        MobileService mobileService = name -> System.out.println("Calling to " + name);

        mobileService.call("Rahul");
    }
}