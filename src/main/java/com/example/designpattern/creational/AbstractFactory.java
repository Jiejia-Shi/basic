package com.example.designpattern.creational;

import lombok.Data;

/**
 * get rid of if-else block of Factory class
 */
public class AbstractFactory {
    public static void main(String[] args) {
        DessertFood cookie = AbstractFactory.getDessert(new CookieFactory());
        System.out.println(cookie.getTaste());
    }

    public static DessertFood getDessert(AbstractDessertFactory abstractDessertFactory) {
        return abstractDessertFactory.createDessert();
    }
}

abstract class AbstractDessertFactory {
    public abstract DessertFood createDessert();
}

class CakeFactory extends AbstractDessertFactory {
    @Override
    public DessertFood createDessert() {
        return new Cake();
    }
}

class CookieFactory extends AbstractDessertFactory {

    @Override
    public DessertFood createDessert() {
        return new Cookie();
    }
}

@Data
class DessertFood {
    private String fruit;
    private String water;
    private String taste;

    public DessertFood(String fruit, String water, String taste) {
        this.fruit = fruit;
        this.water = water;
        this.taste = taste;
    }
}

class Cake extends DessertFood {

    public Cake() {
        super("sugar", "normal water", "soft");
    }
}

class Cookie extends DessertFood {

    public Cookie() {
        super("flour", "sweet water", "crisp");
    }
}

