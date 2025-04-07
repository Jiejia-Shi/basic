package com.example.designpattern.behavioral;

/**
 * provide a template for subclass
 */
public class TemplateMethod {
    public static void main(String[] args) {
        HouseTemplate woodenHouse = new WoodenHouse();
        woodenHouse.buildHouse();
    }

}

abstract class HouseTemplate {

    // template method, final so subclasses can't override
    public final void buildHouse() {
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
    }

    // methods to be implemented by subclasses
    abstract void buildPillars();
    abstract void buildWalls();


    // methods with default implementations
    public void buildFoundation() {
        System.out.println("build normal foundation");
    }

    public void buildWindows() {
        System.out.println("build normal windows");
    }
}

class WoodenHouse extends HouseTemplate {

    @Override
    void buildPillars() {
        System.out.println("build wooden pillars");
    }

    @Override
    public void buildWalls() {
        System.out.println("build wooden walls");
    }

    @Override
    public void buildWindows() {
        System.out.println("build wooden windows");
    }
}
