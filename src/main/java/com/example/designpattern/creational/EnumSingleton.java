package com.example.designpattern.creational;

/**
 * avoid situation with reflection
 * eager initialization
 */
public enum EnumSingleton {
    INSTANCE;

    public static void printEnumSingleton() {
        System.out.println("enum singleton");
    }

    public static void main(String[] args) {
        System.out.println(EnumSingleton.INSTANCE.hashCode());
        EnumSingleton.printEnumSingleton();
    }
}
