package com.example.designpattern.structural;

/**
 * have an object that has more than two features of subclasses
 */
public class Decorator {
    public static void main(String[] args) {
        Car luxuryCar = new LuxuryCar(new BasicCar());
        luxuryCar.assemble();

        System.out.println();
        Car assembledCar = new SportsCar(new LuxuryCar(new BasicCar()));
        assembledCar.assemble();
    }
}

abstract class Car {
    abstract void assemble();
}

class BasicCar extends Car {

    @Override
    void assemble() {
        System.out.print("BasicCar");
    }
}

class CarDecorator extends Car {
    protected Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }
}

class LuxuryCar extends CarDecorator {

    public LuxuryCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" -Add LuxuryCar Feature");
    }

}

class SportsCar extends CarDecorator {
    public SportsCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" -Add SportsCar Feature");
    }

}

