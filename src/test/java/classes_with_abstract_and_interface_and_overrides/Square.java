package classes_with_abstract_and_interface_and_overrides;

import java.awt.*;

public class Square extends Shape implements Drawable {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    private Color fillColor;

    @Override
    public void draw() {

    }

    public void fillColor(Color color) {
        this.fillColor = color;
    }
}
