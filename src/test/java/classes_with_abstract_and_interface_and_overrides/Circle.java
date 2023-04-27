package classes_with_abstract_and_interface_and_overrides;

import java.awt.*;

public class Circle extends Shape implements Drawable{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {

    }

    @Override
    public void fillColor(Color color) {

    }
}
