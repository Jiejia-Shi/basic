package com.example.designpattern.structural;

/**
 * use to decouple the interfaces from implementation and hiding the implementation details from the client program
 * (here we hide the details of how color works)
 */
public class Bridge {
    public static void main(String[] args) {
        BridgeShape rectangle = new BridgeRectangle();
        Color blue = new Blue();
        rectangle.drawShape(blue);
    }
}


abstract class BridgeShape {

    // composition
    abstract void drawShape(Color color);
}

class BridgeRectangle extends BridgeShape {

    @Override
    void drawShape(Color color) {
        System.out.println("draw a rectangle");
        color.useColor();
    }
}

abstract class Color {
    protected String colorName;
    abstract void useColor();

    public Color(String colorName) {
        this.colorName = colorName;
    }
}

class Red extends Color {
    Red() {
        super("red");
    }
    public void useColor() {
        System.out.println("using color " + colorName);
    }
}

class Blue extends Color {
    Blue() {
        super("blue");
    }
    public void useColor() {
        System.out.println("using color " + colorName);
    }
}
