package com.shubin.model.threads;

public class SynchroSingleton {
    private static SynchroSingleton instance;
    private SynchroSingleton() {}

    // double check implementation
    public static SynchroSingleton getInstance() {
        if (instance == null) {
            synchronized (SynchroSingleton.class) {
                if (instance == null) {
                    instance = new SynchroSingleton();
                }
            }
        }
        return instance;
    }
}
