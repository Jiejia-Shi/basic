package com.example.designpattern.creational;

/**
 * initialize instance when it's used
 * not thread safe
 */
public class LazyInitializedSingleton {
    private final String param;

    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton(String param) {
        this.param = param;
    }

    public static LazyInitializedSingleton getInstance() {
        // initialize instance when it's used
        if (instance == null) {
            instance = new LazyInitializedSingleton("lazy initialized singleton");
        }
        return instance;
    }

    public String getParam() {
        return param;
    }

    public static void main(String[] args) {
        LazyInitializedSingleton instance = LazyInitializedSingleton.getInstance();
        System.out.println(instance.getParam());
    }
}
