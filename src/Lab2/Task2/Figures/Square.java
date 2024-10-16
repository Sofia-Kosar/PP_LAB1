package Lab2.Task2.Figures;

import Lab2.Task2.AreaCalculable;

public class Square implements AreaCalculable {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}