package com.kk.creational.singleton.method.initialization;

public class ThreadSafeMethodInitialization {
    private static ThreadSafeMethodInitialization instance;

    private ThreadSafeMethodInitialization() {

    }

    public static synchronized ThreadSafeMethodInitialization getInstance() {
        if (instance == null) {
            instance = new ThreadSafeMethodInitialization();
        }
        return instance;
    }
}
