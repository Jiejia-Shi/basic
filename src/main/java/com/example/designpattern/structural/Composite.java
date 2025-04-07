package com.example.designpattern.structural;

import java.util.ArrayList;
import java.util.List;

/**
 * a structure where objects can be treated the same way
 */
public class Composite {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Rectangle rectangle = new Rectangle();
        Drawing drawing = new Drawing();
        drawing.addShape(triangle);
        drawing.addShape(rectangle);
        triangle.draw("yellow");
        drawing.draw("blue");
    }
}

abstract class Shape {
    abstract void draw(String color);
}

class Triangle extends Shape {

    @Override
    void draw(String color) {
        System.out.println("triangle draws with color " + color);
    }
}

class Rectangle extends Shape {

    @Override
    void draw(String color) {
        System.out.println("rectangle draws with color " + color);
    }
}

class Drawing extends Shape {

    private final List<Shape> shapes;

    public Drawing() {
        shapes = new ArrayList<>();
    }

    // draw every shape
    @Override
    void draw(String color) {
        for (Shape shape : shapes) {
            shape.draw(color);
        }
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }
}
