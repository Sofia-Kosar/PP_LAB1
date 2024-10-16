package Lab2.task2.Figures;
import Lab2.task2.AreaCalculable;

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