package Lab2.Task2.Figures;
import Lab2.Task2.AreaCalculable;

public class Circle implements AreaCalculable {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}