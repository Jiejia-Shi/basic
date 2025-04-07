package com.example.designpattern.creational;

/**
 * use the builder to create instances with required and optional parameters.
 */
public class Builder {
    public static void main(String[] args) {

        //get object in a single line of code without any inconsistent state or arguments management issues
        Drink drink = new Drink.DrinkBuilder("Scarlet Maggie", "strawberry", "bitter")
                .setIsSugarNeeded(false).setIsOnSale(false).build();

        System.out.println(drink.getIsSugarNeeded());
    }
}

class Drink {

    // required parameters
    private String name;
    private String fruit;
    private String taste;

    // optional parameters
    private boolean isSugarNeeded;
    private boolean isOnSale;

    public boolean getIsSugarNeeded() {
        return isSugarNeeded;
    }

    // private constructor with a builder class parameter
    private Drink(DrinkBuilder drinkBuilder) {
        this.name = drinkBuilder.name;
        this.fruit = drinkBuilder.fruit;
        this.taste = drinkBuilder.taste;
        this.isSugarNeeded = drinkBuilder.isSugarNeeded;
        this.isOnSale = drinkBuilder.isOnSale;
    }

    //builder class
    public static class DrinkBuilder {
        // required parameters
        private String name;
        private String fruit;
        private String taste;

        // optional parameters
        private boolean isSugarNeeded;
        private boolean isOnSale;

        // set required parameters in constructor
        public DrinkBuilder(String name, String fruit, String taste) {
            this.name = name;
            this.fruit = fruit;
            this.taste = taste;
        }
        // using setter to set optional parameters
        public DrinkBuilder setIsSugarNeeded(boolean isSugarNeeded) {
            this.isSugarNeeded = isSugarNeeded;
            return this;
        }

        public DrinkBuilder setIsOnSale(boolean isOnSale) {
            this.isOnSale = isOnSale;
            return this;
        }

        public Drink build() {
            return new Drink(this);
        }
    }
}
