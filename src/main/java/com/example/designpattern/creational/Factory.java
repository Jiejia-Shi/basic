package com.example.designpattern.creational;

import lombok.Data;

/**
 * take out the responsibility of the instantiation of a class
 * return sub-classes based on input
 */
public class Factory {
    // this can be further modified to Singleton
    public static Juice getJuice(String juiceType) {
        if ("OJ".equals(juiceType)) {
            return new OrangeJuice();
        } else if ("SJ".equals(juiceType)) {
            return new StrawberryJuice();
        } else {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        Juice juice = Factory.getJuice("SJ");
        System.out.println(juice.getFruit());
    }
}

@Data
class Juice {
    private String fruit;
    private String water;
    private String taste;

    public Juice(String fruit, String water, String taste) {
        this.fruit = fruit;
        this.water = water;
        this.taste = taste;
    }
}

class OrangeJuice extends Juice {

    public OrangeJuice() {
        super("orange", "normal water", "sour");
    }
}

class StrawberryJuice extends Juice {

    public StrawberryJuice() {
        super("strawberry", "sweet water", "sweet");
    }
}

