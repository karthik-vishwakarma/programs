package com.kk.singleton.block.initialization;

public class ThreadSafeBlockInitialization {
    private static ThreadSafeBlockInitialization instance;

    private ThreadSafeBlockInitialization() {

    }

    public static ThreadSafeBlockInitialization getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeBlockInitialization.class) {
                instance = new ThreadSafeBlockInitialization();
            }
        }
        return instance;
    }
}
