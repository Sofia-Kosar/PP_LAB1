package Lab2.task2.Figures;
import Lab2.task2.AreaCalculable;

public class Triangle implements AreaCalculable {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}