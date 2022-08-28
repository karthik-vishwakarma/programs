package com.kk.creational.singleton.lazy;

public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
