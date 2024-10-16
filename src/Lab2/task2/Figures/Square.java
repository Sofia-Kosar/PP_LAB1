package Lab2.task2.Figures;

import Lab2.task2.AreaCalculable;

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