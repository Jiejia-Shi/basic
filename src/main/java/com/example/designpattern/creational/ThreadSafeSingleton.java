package com.example.designpattern.creational;

/**
 * lazy thread safe singleton
 */
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    private final String param;

    private ThreadSafeSingleton(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }

    public static ThreadSafeSingleton getInstance() {
        // avoid extra overhead for each getInstance() after instance being created
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton("thread safe singleton");
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        ThreadSafeSingleton instance = ThreadSafeSingleton.getInstance();
        System.out.println(instance.getParam());
    }
}

