package Lab2.task2.Figures;
import Lab2.task2.AreaCalculable;
import Lab2.task2.CapacityCalculable;

public class Pyramid implements AreaCalculable, CapacityCalculable {
    private final double base;
    private final double height;

    public Pyramid(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return base * base;
    }

    @Override
    public double calculateCapacity() {
        return (1.0 / 3.0) * base * base * height;
    }
}