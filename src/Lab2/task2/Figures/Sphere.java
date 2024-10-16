package Lab2.task2.Figures;
import Lab2.task2.AreaCalculable;
import Lab2.task2.CapacityCalculable;

public class Sphere implements AreaCalculable, CapacityCalculable {
    private final double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double calculateCapacity() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }
}