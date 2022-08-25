package com.kk.singleton.eager;

public class Main {
    public static void main(String[] args) {
        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        System.out.println(eagerSingleton1);
        EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();
        System.out.println(eagerSingleton2);
    }
}