package com.example.designpattern;

/**
 * the instance is created at the time of class loading
 */
public final class EagerInitializedSingleton {
    private final String param;
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton("eager initialized singleton");
    private EagerInitializedSingleton(String param) {
        this.param = param;
    }

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }

    public String getParam() {
        return param;
    }

    public static void main(String[] args) {
        EagerInitializedSingleton singleton = EagerInitializedSingleton.getInstance();
        System.out.println(singleton.getParam());
    }
}
